# Virtual Fields

A virtual field combines fields from a record, or parts of fields, with some literal text,
optionally performing some simple transformations on the field values,
to produce a string, which is used as if it were just another field in the record. 

For example

`FirstName | Lower | Prefix 1 + Literal _ + FullName.Last[0] | Lower`

It is an error to write a record with a field with a name equal to a configured
virtual field name.

It should be possible to define a virtual field in terms of other virtual fields.

An actual spec will be part of another PR.
