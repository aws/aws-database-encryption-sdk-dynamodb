// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.structuredEncryption

use aws.polymorph#reference

// TODO terminalTypes MUST NOT be repeated in this list
// TODO terminalTypes MUST NOT include reserved type for bytes 0xXX
list TypesToRegister {
    member: TypeEntry
}

structure TypeEntry {
    @required
    typeId: TerminalTypeId,
    serializer: TerminalSerializer
}

union TerminalSerializer {
    stringTypeSerializer: TerminalStringSerializerReference,
    boolTypeSerializer: TerminalBoolSerializerReference,
}

@reference(resource: TerminalStringSerializer)
structure TerminalStringSerializerReference {}

resource TerminalStringSerializer {
    operations: [TerminalStringSerialize, TerminalStringDeserialize]
}

operation TerminalStringSerialize {
    input: TerminalStringSerializeInput,
    output: TerminalStringSerializeOutput
}

structure TerminalStringSerializeInput {
    value: String,
}

structure TerminalStringSerializeOutput {
    serializedValue: Blob,
}

operation TerminalStringDeserialize {
    input: TerminalStringDeserializeInput,
    output: TerminalStringDeserializeOutput
}

structure TerminalStringDeserializeInput {
    serializedValue: Blob,
}

structure TerminalStringDeserializeOutput {
    value: String,
}

@reference(resource: TerminalBoolSerializer)
structure TerminalBoolSerializerReference {}

resource TerminalBoolSerializer {
    operations: [TerminalBoolSerialize, TerminalBoolDeserialize]
}

operation TerminalBoolSerialize {
    input: TerminalBoolSerializeInput,
    output: TerminalBoolSerializeOutput
}

structure TerminalBoolSerializeInput {
    value: String,
}

structure TerminalBoolSerializeOutput {
    serializedValue: Blob,
}

operation TerminalBoolDeserialize {
    input: TerminalBoolDeserializeInput,
    output: TerminalBoolDeserializeOutput
}

structure TerminalBoolDeserializeInput {
    serializedValue: Blob,
}

structure TerminalBoolDeserializeOutput {
    value: String,
}
