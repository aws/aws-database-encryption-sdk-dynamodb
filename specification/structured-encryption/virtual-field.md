[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Virtual Fields

## Version

1.0.0

### Changelog

## Overview

A virtual field is a field constructed from parts of other fields, but never stored in the database.

A virtual field can be used in the construction of a [compound beacon](beacons.md#compound-beacon)
which can be stored in the database and can be used to search.

A virtual field is configured by specifying [terminal locations](#terminal location),
[modifying](#field-modifications), and combining them with [literal values](#literal-value).

If an encrypted field is involved in the construction of a virtual field,
then the virtual field can only be used in a [sensitive part](beacons.md#sensitive-part).

For example imagine this fraction of a database record :
```
{
  FirstName : "John",
  FamilyName : {
    LastNames : [
      "Smith",
      "Jones"
    ]
  }
}
```

If one wanted to be able to search on a `NameTag` field that had the value `jsmith`,
one specify `NameTag` to be a virtual field with this configuration :

`FirstName | Prefix 1 | Lower + FamilyName.LastNames[0] | Lower`

If a customer then configured a [standard beacon](#beacons.md#standard-beacon)
on the `NameTag` field, they would then query on
`NameTag = jsmith` and the right record would be retrieved.

The customer is responsible for generating the text "jsmith" at query time.

One of the primary customer benefits is that this allows a beacon on a sub-part
of a structured value.

### Terminal Location

A Terminal Location specifies the location of a piece of data within a structure.
In the example above `FirstName` and `FamilyName.LastNames[0]` are examples of
terminal locations. At the moment, a terminal locations must resolve to a string
(i.e. not a map, list or set) but this might be relaxed in future versions.

A terminal location MUST be a field name followed by zero or more [Segments](#segments)

#### Segments

A Segment MUST be one of

 - A literal "." followed by a field name, indicating a lookup into a Structured Data Map.
 - A literal "[" followed by a decimal integer followed by a literal "]",
indicating an index into a  Structured Data List.

### Field Modifications

The following functions MUST be provided to modify strings

* "Prefix" N - the first N characters (not bytes). The unmodified string if N > length.
* "Suffix" N - the last N characters (not bytes). The unmodified string if N > length.
* "Lower" - any ascii letters replaced with their lowercase equivalent.
* "Upper" - any ascii letters replaced with their uppercase equivalent.
* "Parts" Char Low High - Split the string on Char, keep only the parts Low..High inclusive.
Both Low and High reduced to total parts. High is optional, and defaults to Low.

### Virtual Segment

A virtual segment MUST be one of
 - a [literal value](#literal-value)
 - a [value calculation](#value-calculation)

#### Literal Value

A literal value must be the string "Literal" followed by whitespace followed by
a string that contains no whitespace.

#### Value Calculation

A value calculation MUST be a [terminal location](#terminal-location) followed by zero or more
" | " delimited Field Modifications.

For example, `FirstName | Lower | Prefix 1`

 1 [Stringifys](#stringify) the FirstName field
 1 Converts it to lowercase
 1 Discards all but the first character

### Virtual Field Definition

A virtual value is " + " delimited list of [virtual segments](#virtual-segement).

For example the NameTag example above might be specified as

`FirstName | Prefix 1 | Lower + FamilyName.LastNames[0] | Lower`

Or the full name, with an underscore between the first and last name, would be

`FirstName | Lower + Literal _ + FamilyName.LastNames[0] | Lower`

#### GetVirtualField

The function GetVirtualField MUST be provided, taking a name and a [virtual field definition](#virtual-field-definition) and returning a VirtualField.

### Stringify

A virtual field is always a string, and so all [terminal locations](#terminal-location)
must be converted to strings before being used to construct a virtual field.

Stringify MUST be a a callback function that takes a Terminal Location and returns a string.

This callback is NOT accessible to the customer, but is simply a bridge between the
structured encryption layer and the database layer.

For example, a DynamoDB callback might resolve a Path on an ItemMap and produce
a string based on the type of the Terminal.

####  VirtualField.makeString

A VirtualField MUST provide the method makeString,
which takes a [Stringify](#stringify) and returns a string.

makeString MUST calculate the virtual field as defined above,
translating [terminal locations](#terminal-location) into strings
with the provided [Stringify](#stringify).

### Examiner

It can be important to know if a virtual field has a certain quality,
defined as any of its parts having the quality.

Examiner MUST be a a callback function that takes a Terminal Location and returns a boolean.

For example, an DynamoDB callback might check to see if the top level 
field is encrypted or signed.

#### VirtualField.examine

A VirtualField MUST provide the method examine,
which takes a [Examiner](#examiner) and returns a boolean.

examine MUST return `true` if the [Examiner](#examiner) returns `true`
for any [terminal locations](#terminal-location)] in the virtual field,
and `false` otherwise.

### Limitations

It is an error to write an field with the same name as a
[virtual field](#virtual-field-configuration).

If you write an item with a given field, and later define a virtual field
with that same name, then future searches will search only on the virtual field,
and you will not be able to find the item base on the original field value.

Because of the syntax above

* The ` + ` and ` | ` that delimit pieces must be surrounded by whitespace
* Literal Values and field names cannot contain whitespace.
