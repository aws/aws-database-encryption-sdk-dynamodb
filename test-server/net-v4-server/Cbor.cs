// rpcv2Cbor codec, hand-written on System.Formats.Cbor.
//
// The wire model (aws-crypto-tools-commons/dbesdk/test-server/model) encodes
// each structure as a CBOR map keyed by member name, Blob as a CBOR byte
// string, and enums as text strings. There is no smithy-dotnet rpcv2Cbor
// server codegen, so — exactly as the Java and Rust servers do — the transport
// is hand-written.
//
// Requests are decoded into a generic tree (Dictionary / List / string /
// byte[] / bool / long / double / null): the config shape is a deeply nested
// tagged-union-as-struct, and a tree keeps the reader small and makes "unknown
// keys ignored / absent optional members omitted" fall out for free. Responses
// are built as the same tree and written back symmetrically. Definite-length
// maps/arrays are emitted (byte-compatible with what the real smithy-java
// Test_Client accepts — proven by the cross-language TamperTest matrix).

using System.Formats.Cbor;

namespace Aws.Cryptography.Dbesdk.TestServer;

internal static class Cbor
{
    /// Decode a CBOR document into a generic tree.
    public static object? Decode(byte[] bytes)
    {
        var reader = new CborReader(bytes, CborConformanceMode.Lax);
        return ReadValue(reader);
    }

    /// Encode a generic tree (Dictionary / List / string / byte[] / bool /
    /// int / long / null) into a CBOR document.
    public static byte[] Encode(object? value)
    {
        var writer = new CborWriter(CborConformanceMode.Lax);
        WriteValue(writer, value);
        return writer.Encode();
    }

    private static object? ReadValue(CborReader reader)
    {
        switch (reader.PeekState())
        {
            case CborReaderState.StartMap:
            {
                reader.ReadStartMap();
                var map = new Dictionary<string, object?>();
                while (reader.PeekState() != CborReaderState.EndMap)
                {
                    // rpcv2Cbor structure/map keys are always text strings.
                    string key = reader.ReadTextString();
                    map[key] = ReadValue(reader);
                }
                reader.ReadEndMap();
                return map;
            }
            case CborReaderState.StartArray:
            {
                reader.ReadStartArray();
                var list = new List<object?>();
                while (reader.PeekState() != CborReaderState.EndArray)
                {
                    list.Add(ReadValue(reader));
                }
                reader.ReadEndArray();
                return list;
            }
            case CborReaderState.TextString:
                return reader.ReadTextString();
            case CborReaderState.ByteString:
                return reader.ReadByteString();
            case CborReaderState.Boolean:
                return reader.ReadBoolean();
            case CborReaderState.Null:
                reader.ReadNull();
                return null;
            case CborReaderState.UnsignedInteger:
            case CborReaderState.NegativeInteger:
                return reader.ReadInt64();
            case CborReaderState.HalfPrecisionFloat:
            case CborReaderState.SinglePrecisionFloat:
            case CborReaderState.DoublePrecisionFloat:
                return reader.ReadDouble();
            default:
                // Any other major type is not used by this model; skip it so an
                // unexpected value never aborts decoding of the rest of the map.
                reader.SkipValue();
                return null;
        }
    }

    private static void WriteValue(CborWriter writer, object? value)
    {
        switch (value)
        {
            case null:
                writer.WriteNull();
                break;
            case string s:
                writer.WriteTextString(s);
                break;
            case byte[] b:
                writer.WriteByteString(b);
                break;
            case bool boolean:
                writer.WriteBoolean(boolean);
                break;
            case int i:
                writer.WriteInt32(i);
                break;
            case long l:
                writer.WriteInt64(l);
                break;
            case double d:
                writer.WriteDouble(d);
                break;
            case IReadOnlyDictionary<string, object?> map:
                writer.WriteStartMap(map.Count);
                foreach (var kv in map)
                {
                    writer.WriteTextString(kv.Key);
                    WriteValue(writer, kv.Value);
                }
                writer.WriteEndMap();
                break;
            case IReadOnlyList<object?> list:
                writer.WriteStartArray(list.Count);
                foreach (var item in list)
                {
                    WriteValue(writer, item);
                }
                writer.WriteEndArray();
                break;
            default:
                throw new InvalidOperationException(
                    $"cannot CBOR-encode a value of type {value.GetType()}");
        }
    }
}
