// Typed accessors over the generic CBOR tree (see Cbor.cs). A missing or
// wrong-typed required member is a framework failure (GenericServerError);
// absent optional members return null. Keeps the factory and handlers free of
// repetitive cast-and-check boilerplate.

namespace Aws.Cryptography.Dbesdk.TestServer;

internal static class Wire
{
    public static Dictionary<string, object?> AsMap(object? value, string what)
    {
        if (value is Dictionary<string, object?> map)
        {
            return map;
        }
        throw ServerException.Generic($"{what} must be a CBOR map");
    }

    public static string RequireString(Dictionary<string, object?> map, string key)
    {
        if (map.TryGetValue(key, out var value) && value is string s)
        {
            return s;
        }
        throw ServerException.Generic($"missing or non-string required member '{key}'");
    }

    public static string? OptString(Dictionary<string, object?> map, string key)
    {
        return map.TryGetValue(key, out var value) && value is string s ? s : null;
    }

    public static byte[] RequireBytes(Dictionary<string, object?> map, string key)
    {
        if (map.TryGetValue(key, out var value) && value is byte[] b)
        {
            return b;
        }
        throw ServerException.Generic($"missing or non-blob required member '{key}'");
    }

    public static byte[]? OptBytes(Dictionary<string, object?> map, string key)
    {
        return map.TryGetValue(key, out var value) && value is byte[] b ? b : null;
    }

    public static int RequireInt(Dictionary<string, object?> map, string key)
    {
        if (map.TryGetValue(key, out var value) && value is long l)
        {
            return checked((int)l);
        }
        throw ServerException.Generic($"missing or non-integer required member '{key}'");
    }

    public static Dictionary<string, object?> RequireMap(Dictionary<string, object?> map, string key)
    {
        if (map.TryGetValue(key, out var value))
        {
            return AsMap(value, $"member '{key}'");
        }
        throw ServerException.Generic($"missing required member '{key}'");
    }

    public static Dictionary<string, object?>? OptMap(Dictionary<string, object?> map, string key)
    {
        return map.TryGetValue(key, out var value) && value is Dictionary<string, object?> m ? m : null;
    }

    public static List<string>? OptStringList(Dictionary<string, object?> map, string key)
    {
        if (!map.TryGetValue(key, out var value) || value is not List<object?> list)
        {
            return null;
        }
        var result = new List<string>(list.Count);
        foreach (var item in list)
        {
            if (item is string s)
            {
                result.Add(s);
            }
            else
            {
                throw ServerException.Generic($"member '{key}' must be a list of strings");
            }
        }
        return result;
    }
}
