// clientId -> real DBE item encryptor cache. CreateClient builds one encryptor,
// registers it under a fresh UUID, and returns the id; EncryptItem / DecryptItem
// look it up. Mirrors the Java `ClientRegistry`.
//
// Each registered client carries a per-client async lock (`op_lock`) that
// serializes operations on THAT client. The DBE (Dafny-transpiled) client runs
// its async KMS calls by blocking a tokio worker thread (`block_in_place` +
// nested `block_on`) and guards its keyring with an internal `std::Mutex`.
// Issuing concurrent operations on one client therefore piles up blocked
// workers all contending that internal mutex, which deadlocks the whole tokio
// runtime (the server then accepts TCP connections but answers none). Holding
// `op_lock` across a client's operation removes the concurrency the DBE client
// cannot tolerate; distinct clients still run in parallel (they own distinct
// internal mutexes), so cross-pair work is unaffected.

use crate::error::ServerError;
use aws_db_esdk::item_encryptor::client::Client as ItemEncryptor;
use aws_db_esdk::Client as TransformsClient;
use std::collections::HashMap;
use std::sync::{Arc, Mutex};
use uuid::Uuid;

/// A registered DBE item encryptor plus the async lock that serializes its
/// operations (see the module comment for why serialization is required).
pub struct ClientHandle {
    pub encryptor: ItemEncryptor,
    pub op_lock: tokio::sync::Mutex<()>,
}

/// A registered DBE DDB-SDK transforms client plus the async lock that
/// serializes its operations. The transforms client is a DBE (Dafny-transpiled)
/// client with the same no-concurrent-calls constraint as the item encryptor.
pub struct TransformsHandle {
    pub client: TransformsClient,
    pub op_lock: tokio::sync::Mutex<()>,
}

#[derive(Clone, Default)]
pub struct ClientRegistry {
    clients: Arc<Mutex<HashMap<String, Arc<ClientHandle>>>>,
    transforms: Arc<Mutex<HashMap<String, Arc<TransformsHandle>>>>,
}

impl ClientRegistry {
    pub fn new() -> Self {
        Self::default()
    }

    /// Register a freshly-built encryptor and return its non-empty UUID id.
    pub fn register(&self, encryptor: ItemEncryptor) -> String {
        let id = Uuid::new_v4().to_string();
        let handle = Arc::new(ClientHandle {
            encryptor,
            op_lock: tokio::sync::Mutex::new(()),
        });
        self.clients
            .lock()
            .expect("client registry mutex poisoned")
            .insert(id.clone(), handle);
        id
    }

    /// Resolve a registered client handle, or a GenericServerError naming the
    /// bad id.
    pub fn get(&self, client_id: &str) -> Result<Arc<ClientHandle>, ServerError> {
        self.clients
            .lock()
            .expect("client registry mutex poisoned")
            .get(client_id)
            .cloned()
            .ok_or_else(|| ServerError::Generic(format!("unknown clientId '{client_id}'")))
    }

    /// Register a freshly-built transforms client and return its non-empty
    /// UUID id. Kept in a separate map from item encryptors so the two client
    /// kinds never collide on an id.
    pub fn register_transforms(&self, client: TransformsClient) -> String {
        let id = Uuid::new_v4().to_string();
        let handle = Arc::new(TransformsHandle {
            client,
            op_lock: tokio::sync::Mutex::new(()),
        });
        self.transforms
            .lock()
            .expect("transforms registry mutex poisoned")
            .insert(id.clone(), handle);
        id
    }

    /// Resolve a registered transforms client handle, or a GenericServerError
    /// naming the bad id.
    pub fn get_transforms(&self, client_id: &str) -> Result<Arc<TransformsHandle>, ServerError> {
        self.transforms
            .lock()
            .expect("transforms registry mutex poisoned")
            .get(client_id)
            .cloned()
            .ok_or_else(|| ServerError::Generic(format!("unknown transforms clientId '{client_id}'")))
    }
}
