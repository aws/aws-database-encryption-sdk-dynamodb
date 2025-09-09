#!/usr/bin/env python3

"""
Optimization proposals based on line profiling analysis of new_implementation()

PROFILING ANALYSIS:
===================
Line #28 (for loop): 24.9% of total time (424,475,000 ns)
Line #30 (isinstance/ord): 24.6% of total time (419,846,000 ns)  
Line #32 (high byte): 24.7% of total time (420,885,000 ns)
Line #33 (low byte): 24.6% of total time (419,095,000 ns)

Total loop overhead: ~98.8% of execution time
"""

import struct
from _dafny import Seq

def original_implementation(dafny_ascii_string):
    """Original implementation that converts UTF-16 code units to string"""
    try:
        return b''.join([
            c.to_bytes(2, byteorder="big")
            if isinstance(c, int)
            else ord(c).to_bytes(2, byteorder="big")
            for c in dafny_ascii_string
        ]).decode("utf-16-be", errors='strict')
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


def current_new_implementation(dafny_ascii_string):
    """Current implementation from profiling"""
    try:
        length = len(dafny_ascii_string)
        byte_buffer = bytearray(length * 2)  # 2 bytes per character
        
        # Direct buffer manipulation
        for i, c in enumerate(dafny_ascii_string):
            value = c if isinstance(c, int) else ord(c)
            # Place bytes directly in buffer
            byte_buffer[i*2] = (value >> 8) & 0xFF    # high byte
            byte_buffer[i*2 + 1] = value & 0xFF       # low byte
        
        return bytes(byte_buffer).decode("utf-16-be", errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 1: Use struct.pack to eliminate manual byte manipulation
def optimized_v1_struct_pack(dafny_ascii_string):
    """Use struct.pack for efficient byte packing"""
    try:
        if not dafny_ascii_string:
            return ""
        
        # Convert all to integers first
        values = []
        for char in dafny_ascii_string:
            values.append(ord(char) if isinstance(char, str) else char)
        
        # Pack all at once using struct
        format_str = '>' + 'H' * len(values)
        buffer = struct.pack(format_str, *values)
        
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 2: Eliminate isinstance() by pre-processing types
def optimized_v2_type_separation(dafny_ascii_string):
    """Separate type checking from main loop"""
    try:
        if not dafny_ascii_string:
            return ""
        
        length = len(dafny_ascii_string)
        buffer = bytearray(length * 2)
        
        # Check first element to determine likely type pattern
        if dafny_ascii_string and isinstance(dafny_ascii_string[0], str):
            # Assume mostly strings - optimize for strings
            for i in range(length):
                char = dafny_ascii_string[i]
                if isinstance(char, str):
                    value = ord(char)
                else:
                    value = char
                buffer[i*2] = (value >> 8) & 0xFF
                buffer[i*2 + 1] = value & 0xFF
        else:
            # Assume mostly integers - optimize for integers  
            for i in range(length):
                char = dafny_ascii_string[i]
                if isinstance(char, int):
                    value = char
                else:
                    value = ord(char)
                buffer[i*2] = (value >> 8) & 0xFF
                buffer[i*2 + 1] = value & 0xFF
            
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 3: Use manual indexing instead of enumerate
def optimized_v3_manual_indexing(dafny_ascii_string):
    """Use manual indexing instead of enumerate to reduce function call overhead"""
    try:
        length = len(dafny_ascii_string)
        if length == 0:
            return ""
            
        buffer = bytearray(length * 2)
        
        # Manual indexing instead of enumerate
        for i in range(length):
            char = dafny_ascii_string[i]
            value = ord(char) if isinstance(char, str) else char
            buffer[i*2] = (value >> 8) & 0xFF
            buffer[i*2 + 1] = value & 0xFF
            
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 4: Use memoryview for potentially faster buffer access
def optimized_v4_memoryview(dafny_ascii_string):
    """Use memoryview for potentially faster buffer operations"""
    try:
        length = len(dafny_ascii_string)
        if length == 0:
            return ""
            
        buffer = bytearray(length * 2)
        mv = memoryview(buffer)
        
        for i in range(length):
            char = dafny_ascii_string[i]
            value = ord(char) if isinstance(char, str) else char
            mv[i*2] = (value >> 8) & 0xFF
            mv[i*2 + 1] = value & 0xFF
            
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 5: Combine struct.pack with type preprocessing
def optimized_v5_hybrid(dafny_ascii_string):
    """Hybrid approach: preprocess types, then use struct.pack"""
    try:
        if not dafny_ascii_string:
            return ""
        
        # Pre-process all values to integers in one pass
        values = []
        values_append = values.append  # Cache the append method
        
        for char in dafny_ascii_string:
            if isinstance(char, str):
                values_append(ord(char))
            else:
                values_append(char)
        
        # Pack all at once
        buffer = struct.pack('>' + 'H' * len(values), *values)
        
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 6: Ultra-optimized with minimal function calls
def optimized_v6_minimal_calls(dafny_ascii_string):
    """Minimize function calls and optimize for common cases"""
    try:
        length = len(dafny_ascii_string)
        if length == 0:
            return ""
        
        # Pre-allocate and cache frequently used operations
        buffer = bytearray(length * 2)
        
        # Cache the isinstance function to reduce attribute lookup
        isinstance_check = isinstance
        ord_func = ord
        
        # Use manual loop with cached operations
        for i in range(length):
            char = dafny_ascii_string[i]
            
            # Optimized type check and conversion
            if isinstance_check(char, str):
                value = ord_func(char)
            else:
                value = char
            
            # Direct bit operations with manual indexing
            buffer[i*2] = value >> 8
            buffer[i*2 + 1] = value & 0xFF
            
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# OPTIMIZATION 7: Pure struct.pack with list comprehension
def optimized_v7_pure_struct(dafny_ascii_string):
    """Pure struct.pack approach with list comprehension"""
    try:
        if not dafny_ascii_string:
            return ""
        
        # Single list comprehension to convert all values
        values = [ord(c) if isinstance(c, str) else c for c in dafny_ascii_string]
        
        # Single struct.pack call
        buffer = struct.pack('>' + 'H' * len(values), *values)
        
        return buffer.decode('utf-16be', errors='strict')
        
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")


# Test all optimizations
def test_all_optimizations():
    """Test all optimization variants for correctness"""
    test_cases = [
        Seq(['H', 'e', 'l', 'l', 'o']),
        Seq([72, 101, 108, 108, 111]),
        Seq([72, 'e', 108, 'l', 111]),
        Seq(['A'] * 100),
        Seq([ord('A') + (i % 26) for i in range(50)]),
        Seq([]),
        Seq([0x4F60, 0x597D]),
    ]
    
    implementations = [
        ("Current", current_new_implementation),
        ("V1: struct.pack", optimized_v1_struct_pack),
        ("V2: type separation", optimized_v2_type_separation),
        ("V3: manual indexing", optimized_v3_manual_indexing),
        ("V4: memoryview", optimized_v4_memoryview),
        ("V5: hybrid", optimized_v5_hybrid),
        ("V6: minimal calls", optimized_v6_minimal_calls),
        ("V7: pure struct", optimized_v7_pure_struct),
    ]
    
    print("🧪 Testing all optimization variants for correctness...")
    
    for i, test_case in enumerate(test_cases):
        print(f"\n  Test case {i+1}: {len(test_case)} characters")
        
        # Get reference result
        try:
            reference = current_new_implementation(test_case)
        except Exception as e:
            print(f"    Reference failed: {e}")
            continue
            
        # Test all variants
        for name, impl in implementations[1:]:  # Skip current (reference)
            try:
                result = impl(test_case)
                if result == reference:
                    print(f"    ✅ {name}: PASS")
                else:
                    print(f"    ❌ {name}: FAIL - Different result")
                    print(f"       Expected: {repr(reference)}")
                    print(f"       Got:      {repr(result)}")
            except Exception as e:
                print(f"    ❌ {name}: ERROR - {e}")


if __name__ == '__main__':
    test_all_optimizations()
