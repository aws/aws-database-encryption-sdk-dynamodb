// Class VirtualTransform
// Dafny class VirtualTransform compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class VirtualTransform {
  public VirtualTransform() { }

  private static final VirtualTransform theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform.create_upper(Upper.Default());
  public static VirtualTransform Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<VirtualTransform> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(VirtualTransform.class, () -> Default());
  public static dafny.TypeDescriptor<VirtualTransform> _typeDescriptor() {
    return (dafny.TypeDescriptor<VirtualTransform>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static VirtualTransform create_upper(Upper upper) {
    return new VirtualTransform_upper(upper);
  }
  public static VirtualTransform create_lower(Lower lower) {
    return new VirtualTransform_lower(lower);
  }
  public static VirtualTransform create_insert(Insert insert) {
    return new VirtualTransform_insert(insert);
  }
  public static VirtualTransform create_prefix(GetPrefix prefix) {
    return new VirtualTransform_prefix(prefix);
  }
  public static VirtualTransform create_suffix(GetSuffix suffix) {
    return new VirtualTransform_suffix(suffix);
  }
  public static VirtualTransform create_substring(GetSubstring substring) {
    return new VirtualTransform_substring(substring);
  }
  public static VirtualTransform create_segment(GetSegment segment) {
    return new VirtualTransform_segment(segment);
  }
  public static VirtualTransform create_segments(GetSegments segments) {
    return new VirtualTransform_segments(segments);
  }
  public boolean is_upper() { return this instanceof VirtualTransform_upper; }
  public boolean is_lower() { return this instanceof VirtualTransform_lower; }
  public boolean is_insert() { return this instanceof VirtualTransform_insert; }
  public boolean is_prefix() { return this instanceof VirtualTransform_prefix; }
  public boolean is_suffix() { return this instanceof VirtualTransform_suffix; }
  public boolean is_substring() { return this instanceof VirtualTransform_substring; }
  public boolean is_segment() { return this instanceof VirtualTransform_segment; }
  public boolean is_segments() { return this instanceof VirtualTransform_segments; }
  public Upper dtor_upper() {
    VirtualTransform d = this;
    return ((VirtualTransform_upper)d)._upper;
  }
  public Lower dtor_lower() {
    VirtualTransform d = this;
    return ((VirtualTransform_lower)d)._lower;
  }
  public Insert dtor_insert() {
    VirtualTransform d = this;
    return ((VirtualTransform_insert)d)._insert;
  }
  public GetPrefix dtor_prefix() {
    VirtualTransform d = this;
    return ((VirtualTransform_prefix)d)._prefix;
  }
  public GetSuffix dtor_suffix() {
    VirtualTransform d = this;
    return ((VirtualTransform_suffix)d)._suffix;
  }
  public GetSubstring dtor_substring() {
    VirtualTransform d = this;
    return ((VirtualTransform_substring)d)._substring;
  }
  public GetSegment dtor_segment() {
    VirtualTransform d = this;
    return ((VirtualTransform_segment)d)._segment;
  }
  public GetSegments dtor_segments() {
    VirtualTransform d = this;
    return ((VirtualTransform_segments)d)._segments;
  }
}
