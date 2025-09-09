from dataclasses import dataclass
from typing import List
import pytest
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


def new_implementation(dafny_ascii_string):
    """Truly efficient implementation using pre-allocated bytearray"""
    try:
        # Pre-allocate bytearray with known size
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



# Test cases for valid inputs
test_cases = [
    # Basic ASCII
    (Seq(['H', 'e', 'l', 'l', 'o']), "Hello"),
    
    # Integer inputs
    (Seq([72, 101, 108, 108, 111]), "Hello"),
    
    # Mixed inputs
    (Seq([72, 'e', 108, 'l', 'o']), "Hello"),
    
    # Chinese characters
    (Seq([0x4F60, 0x597D]), "你好"),
    
    # Empty sequence
    (Seq([]), ""),
    
    # Null character
    (Seq([0x0000]), "\x00"),
    
    # Maximum BMP value
    (Seq([0xFFFF]), "\uffff"),
    
    # Emoji (as surrogate pair)
    (Seq([0xD83D, 0xDE00]), "😀"),
]

# Error test cases
error_test_cases = [
    # Invalid surrogate pairs
    Seq([0xD800]),  # Incomplete surrogate pair
    Seq([0xDC00]),  # Lone low surrogate
]


@pytest.mark.parametrize("test_input,expected", test_cases)
def test_utf16_conversion_valid_cases(test_input, expected):
    """Test UTF-16 conversion with valid inputs"""
    orig_result = original_implementation(test_input)
    new_result = new_implementation(test_input)
    
    # Test equality between implementations
    assert orig_result == new_result, \
        f"Results differ for input {test_input}"
    
    # Test against expected output
    assert new_result == expected, \
        f"Output doesn't match expected for input {test_input}"
    
    # Test UTF-8 encoding compatibility
    assert orig_result.encode('utf-8') == new_result.encode('utf-8'), \
        f"UTF-8 encoding differs for input {test_input}"


@pytest.mark.parametrize("error_case", error_test_cases)
def test_utf16_conversion_error_cases(error_case):
    """Test UTF-16 conversion with invalid inputs that should raise exceptions"""
    # Both implementations should raise UnicodeError for invalid input
    with pytest.raises(UnicodeError) as orig_exc_info:
        original_implementation(error_case)
    
    with pytest.raises(UnicodeError) as new_exc_info:
        new_implementation(error_case)
    
    # Check that both implementations raise the same type of exception
    assert type(orig_exc_info.value) == type(new_exc_info.value), \
        f"Different exceptions raised for error case {error_case}"


def test_utf16_conversion_comprehensive():
    """Comprehensive test of UTF-16 conversion comparing both implementations"""
    # Test all valid cases in a single comprehensive test
    for test_input, expected in test_cases:
        orig_result = original_implementation(test_input)
        new_result = new_implementation(test_input)
        
        assert orig_result == new_result, \
            f"Results differ for input {test_input}"
        assert new_result == expected, \
            f"Output doesn't match expected for input {test_input}"
        assert orig_result.encode('utf-8') == new_result.encode('utf-8'), \
            f"UTF-8 encoding differs for input {test_input}"
    
    # Test all error cases
    for error_case in error_test_cases:
        with pytest.raises(UnicodeError):
            original_implementation(error_case)
        with pytest.raises(UnicodeError):
            new_implementation(error_case)


if __name__ == '__main__':
    pytest.main([__file__, '-v'])
