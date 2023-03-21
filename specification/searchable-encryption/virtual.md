[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Virtual Fields

## Version

1.0.0

### Changelog

## Overview

Virtual fields are a work in progress, and not yet part of the database encryption project.

A virtual field is a field constructed from parts of other fields, but never stored.

A virtual field can be used in the construction of a [compound beacon](./compound-beacons.md)
which can be stored in the database and can be used to search.

For example a virtual NameTag field, which is constructed from the first letter of the FirstName
field followed by the LastName field, all in lowercase.

When querying, the customer must construct the virtual field value, and use it like
any other search term, e.g. `NameTag=jsmith`. Other than this, and the initial configuration,
the user experience is the same as if there were no virtual beacons, e.g. results never
contain virtual field values.

One of the primary customer benefits is that this allows a beacon on a sub-part
of a structured value.

### Terminal Location

A Terminal Location is a Path to a part of a piece of structured data.

A Terminal Location specification MUST be a list of one more [Segments](#segments),
the first one of which must be a string index.

#### Segments

A Segment MUST be one of

 - A literal "." followed by a field name, indicating a lookup into a Structured Data Map.
 - A literal "[" followed by a decimal integer followed by a literal "]",
indicating an index into a  Structured Data List.

### Stringify

A virtual field is always a string, and so all [source paths](#source-path)
must be converted to strings before being used to construct a virtual field.

Stringify MUST be a a callback function that takes a Terminal Location and returns a string.

The DynamoDB callback resolves a Path on an ItemMap and produces
a string based on the type of the Terminal.

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

For example `Literal _` or `Literal foo`.

#### Value Calculation

A value calculation MUST be a [Terminal Location](#terminal-location) followed by zero or more
" | " delimited Field Modifications.

For example, `FirstName | Lower | Prefix 1`

 1 Stringifys the FirstName field
 1 Converts it to lowercase
 1 Discards all but the first character

### Virtual Field Definition

A virtual value is " + " delimited list of [virtual segments](#virtual-segement).

For example the NameTag example above might be specified as

`FirstName | Lower | Prefix 1 + LastName | Lower`

Or the same thing, with an underscore between the parts

`FirstName | Lower | Prefix 1 + Literal _ + LastName | Lower`

### Virtual Field Initialization

On initialization of a Virtual Field, the caller MUST provide:

 * A name -- a string
 * A [Virtual Field Definition](#virtual-field-definition) -- a string

[Beacons](beacons.md) can be defined in terms of virtual fields or regular record fields.

### Limitations

Because of the syntax above

* The ` + ` and ` | ` that delimit pieces must be surrounded by whitespace
* Literal Values and field names cannot contain whitespace.
