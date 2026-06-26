// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * The server-controlled, generic item representation used by the Enhanced Client adapter.
 *
 * <p>The DynamoDB Enhanced Client maps a Java object to/from a DynamoDB item via a {@code
 * TableSchema}. Rather than require a hand-written, annotated POJO per test (as {@code
 * EnhancedPutGetExample} does with {@code SimpleClass4}), the adapter models every item as a plain
 * attribute map: attribute name to AWS SDK v2 {@link AttributeValue}. This class is exactly that
 * map (it <i>is</i> a {@code Map<String, AttributeValue>}), which lets a single, dynamically built
 * {@code StaticTableSchema<AttributeMapItem>} round-trip arbitrary modeled items without any
 * per-test Java class.
 *
 * <p>It extends {@link HashMap} so the enhanced client's generated getters/setters can read and
 * write attribute entries directly, and so the schema's {@code newItemSupplier} can create a fresh,
 * empty item with {@code AttributeMapItem::new}.
 *
 * @see GenericItemTableSchemas
 */
public final class AttributeMapItem extends HashMap<String, AttributeValue> {

  private static final long serialVersionUID = 1L;

  /** Creates an empty item. Used by the schema's item supplier. */
  public AttributeMapItem() {
    super();
  }

  /**
   * Creates an item pre-populated from an existing attribute map.
   *
   * @param attributes the attributes to copy; must not be {@code null}
   */
  public AttributeMapItem(final Map<String, AttributeValue> attributes) {
    super(attributes);
  }
}
