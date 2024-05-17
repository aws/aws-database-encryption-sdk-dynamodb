[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Virtual Fields

## Version

1.0.0

### Changelog

## Overview

A virtual field is a field constructed from parts of other fields, but never stored.

A virtual field can be used in the construction of a [beacon](beacons.md)
which can be stored in the database and can be used to search.

For example a virtual NameTag field, which is constructed from the first letter of the FirstName
field followed by the LastName field, all in lowercase.

When querying, the customer must construct the virtual field value, and use it like
any other search term, e.g. `NameTag=jsmith`. Other than this, and the initial configuration,
the user experience is the same as if there were no virtual beacons, e.g. results never
contain virtual field values.

### Virtual Field Initialization

On initialization of a Virtual Field, the caller MUST provide:

- A name -- a string
- A list of [Virtual Parts](#virtual-part-initialization)

The evaluation of a Virtual Field MUST be the concatenation of all of its parts,
in the order they are configured.

Initialization MUST fail if two virtual fields are defined with the same set of locations.

Initialization MUST fail if a virtual field is defined with only one location,
and also a [standard beacon](beacons.md#standard-beacon) is defined with that same location.

### Virtual Part Initialization

On initialization of a Virtual Part, the caller MUST provide:

- A location -- a [Terminal Location](#terminal-location)

On initialization of a Virtual Part, the caller MAY provide:

- A list of [Virtual Transforms](#virtual-transform-initialization)

The evaluation of a Virtual Part MUST be the value of its location,
which is then transformed by each Virtual Transform,
in the order they are configured.

Evaluation MUST return no value if the location does not exist,
or is not a plain string value.

### Virtual Transform Initialization

On initialization of a Virtual Transform, the caller MUST provide exactly one of

- an [Upper](#upper-transform-initialization) transform
- a [Lower](#lower-transform-initialization) transform
- an [Insert](#insert-transform-initialization) transform
- a [GetPrefix](#getprefix-transform-initialization) transform
- a [GetSuffix](#getsuffix-transform-initialization) transform
- a [GetSubstring](#getsubstring-transform-initialization) transform
- a [GetSegment](#getsegment-transform-initialization) transform
- a [GetSegments](#getsegments-transform-initialization) transform

All transforms take a string as input and produce a string as output.

### Upper Transform Initialization

On initialization of an Upper Transform, the caller MUST NOT provide any
additional parameters to the Upper Transform.

The Upper transform MUST convert all ascii lowercase characters into their uppercase equivalents.

### Lower Transform Initialization

On initialization of a Lower Transform, the caller MUST NOT provide any
additional parameters to the Lower Transform.

The Lower transform MUST convert all ascii uppercase characters into their lowercase equivalents.

### Insert Transform Initialization

On initialization of an Insert Transform, the caller MUST provide:

- a literal string

The Insert transform MUST append this string to its input

### GetPrefix Transform Initialization

On initialization of a GetPrefix Transform, the caller MUST provide:

- length : an integer

If length is non-negative, the GetPrefix transform MUST return the first `length` characters of the input.

If length is non-negative, and length exceeds the length of the string, the input string MUST be returned.

If length is negative, then the GetPrefix transform MUST return
all but the last `-length` character of the input.

If length is negative and -length exceeds the length on the input,
the empty string MUST be returned.

### GetSuffix Transform Initialization

On initialization of a GetSuffix Transform, the caller MUST provide:

- length : an integer

If length is non-negative, the GetSuffix transform MUST return the last `length` characters of the input.

If length is non-negative, and length exceeds the length of the string, the input string MUST be returned.

If length is negative, then the GetSuffix transform MUST return
all but the first `-length` character of the input.

If length is negative and -length exceeds the length on the input,
the empty string MUST be returned.

### Position Definition

The transforms below refer to positions within a list.

If the position provided is positive, it MUST be the zero-based index from the start of the list.

If the position provided is negative, it's absolute value MUST be the
one-based index from the end of the list, that is, -1 refers to the last item in the list.

Positions are always clamped to the bounds of the list. That is `-999999999` refers to the first item in the list, and `999999999` refers to the position just after the last item in the list.

### GetSubstring Transform Initialization

On initialization of a GetSubstring Transform, the caller MUST provide:

- low : an integer [position](#position-definition)
- high : an integer [position](#position-definition)

The GetSubstring transform MUST return the range of characters
from low (inclusive) to high (exclusive)

If high is less than or equal to low, an empty string is returned.

### GetSegment Transform Initialization

On initialization of a GetSegment Transform, the caller MUST provide:

- split : an character
- index : an integer [position](#position-definition)

The GetSegment transform MUST split the input string on the given character,
and return the item in the resulting list the corresponds to the given position.

If index is greater than the number of items in the list, an empty string MUST be returned.

### GetSegments Transform Initialization

On initialization of a GetSegments Transform, the caller MUST provide:

- split : an character
- low : an integer [position](#position-definition)
- high : an integer [position](#position-definition)

The GetSegments transform MUST split the input string on the `split` character.

GetSegments MUST return the range of parts from low (inclusive) to high (exclusive),
joined on the `split` character.

If high is less than or equal to low, an empty string MUST be returned.

### Terminal Location

A Terminal Location is a Path to a part of a piece of structured data.

It is exactly equivalent to a DynamoDB document path, e.g. `foo` or `foo.bar` or `foo.bar[3].baz`

A Terminal Location specification MUST be a list of one more [Segments](#segments),
the first one of which must be a string index.

#### Segments

A Segment MUST be one of

- A literal "." followed by a field name, indicating a lookup into a Structured Data Map.
- A literal "[" followed by a decimal integer followed by a literal "]",
  indicating an index into a Structured Data List.
