[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Simplify Structure Encryption

The problems with structured encryption are twofold:

1. The existing recursive structures are needlessly complex
2. The existing structures are not actually suitable for encrypting nested structures.

So we'll look at the changes in two steps : Simplify and Add Structure

## Simplify

There were three parallel data structures, for StructuredData, CryptoSchema and AuthenticateSchema.

This is the CryptoSchema as an example

```smithy
structure CryptoSchema {
    content: CryptoSchemaContent,
    attributes: CryptoSchemaAttributes
}

union CryptoSchemaContent {
    Action: CryptoAction,
    SchemaMap: CryptoSchemaMap,
    SchemaList: CryptoSchemaList
}

map CryptoSchemaMap {
    key: String,
    value: CryptoSchema
}

list CryptoSchemaList {
    member: CryptoSchema
}

map CryptoSchemaAttributes {
    key: String,
    value: AuthenticateAction
}
```

The DynamoDB encryption client restricted itself to a flattened subset of this,
such that a CryptoSchema's attributes were always `None` and the content was always a CryptoSchemaMap
whose values were always a CryptoAction.

Thus we might as well replace the whole thing with

```smithy
map CryptoSchemaMap {
    key: String,
    value: CryptoAction
}
```

which gives us all the flexibility we actually use.

## Add Structure

You might ask "why not use the structure you just removed?".

The old way to say that A.B is SIGN_ONLY and A.C is ENCRYPT_AND_SIGN is a much more complicated version of this:

```dafny
SchemaMap("A" := SchemaMap("B" := SIGN_ONLY, "C" := ENCRYPT_AND_SIGN)));
DataMap("A" := DataMap("B" := SomeBytes, "C" := OtherBytes)));
```

Among the difficulties here is that there is no straightforward way to test if both the Schema and the Data contain the same things, i.e. A.B and A.C. The obvious Schema.Keys == Data.Keys evaluates to true, but is only comparing the “A”‘s, which is a sharp edge best avoided.

So the existing smithy model makes nested structures difficult to write and difficult to reason about.

More useful would be something more like this :

CryptoSchema ("A.B" := SIGN_ONLY, "A.C" := ENCRYPT_AND_SIGN);
StructuredData("A.B" := SomeBytes, "A.C" := OtherBytes));

Thus we introduce the type `Path` which is a sequence of member strings,
so the two paths in the example above would be ["A","B"] and ["A","C"].

The Path is really the more complex :

```smithy
structure StructureSegment {@required key : String}
union PathSegment {
    member: StructureSegment,
}
list Path {
    member: PathSegment
}
```

So that in the future it can become something like

```smithy
structure StructureSegment {@required key : String}
@range(min:0)
integer Position
structure ListSegment {@required key : Position}
structure AttributeSegment {@required key : String}
union PathSegment {
    member: StructureSegment,
    list: ListSegment,
    attribute: AttributeSegment,
}
list Path {
    member: PathSegment
}
```

To capture a more comprehensive set of structures.

The obvious next step is to change the maps to this form:

```smithy
map CryptoSchemaMap {
    key: Path,
    value: CryptoAction
}
```

but we can't do that, because smithy maps can only have keys of type `string`.

So what to do?

Speaking of complexity, every operation either takes a CryptoSchemaMap and a StructuredDataMap,
or an AuthSchemaMap and a StructuredDataMap.
Much code exists to ensure that the two maps have the same keys,
and to ensure that the intermediate maps similarly maintain the same sets of keys.

A third bit of complexity is that, at its lowest level, Structure Encryption works on
an ordered list of entries, and so internally we must convert from map to list and back to map.

Solving all three problems, instead of a CryptoSchemaMap and a StructuredDataMap,
we have a single list of structures containing

- Path
- StructuredDataTerminal
- CryptoAction

This way, there is no way to have mismatching maps, because every data must have an action,
and every action must have a data.

The only bit of added complexity is verifying that all the paths in the input list are unique.
