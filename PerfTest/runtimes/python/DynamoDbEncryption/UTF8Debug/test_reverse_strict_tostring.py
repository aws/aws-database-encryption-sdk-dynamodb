#!/usr/bin/env python3
"""
Test script to compare original and proposed implementations of _reverse_strict_tostring
for correctness across different input types.
"""

import struct
import sys
import os

# Add the path to import _dafny
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', '..', '..', '..', '..', 'myenv', 'lib', 'python3.12', 'site-packages'))

import _dafny

def original_reverse_strict_tostring(utf8_str):
    """Original implementation"""
    utf16_bytes = utf8_str.encode("utf-16-be", errors="strict")
    out = []
    for i in range(int(len(utf16_bytes)/2)):
        utf_16_bytepair = utf16_bytes[2*i:2*i+2]
        packed_bytes = struct.unpack('>H', utf_16_bytepair)
        char_representation = chr(packed_bytes[0])
        out.append(char_representation)
    return _dafny.Seq(out)

def proposed_reverse_strict_tostring(utf8_str):
    """Proposed optimized implementation"""
    utf16_bytes = utf8_str.encode("utf-16-be", errors="strict")
    length = len(utf16_bytes) // 2
    
    # Create list of UTF-16 code points directly
    result = []
    
    for i in range(length):
        # Reconstruct the 16-bit UTF-16 code point
        code_point = (utf16_bytes[i*2] << 8) | utf16_bytes[i*2 + 1]
        result.append(chr(code_point))
    
    return _dafny.Seq(result)

def compare_sequences(seq1, seq2, test_name):
    """Compare two Dafny sequences for equality"""
    try:
        # Convert to lists for comparison
        list1 = list(seq1.Elements)
        list2 = list(seq2.Elements)
        
        if list1 == list2:
            print(f"✓ {test_name}: PASS")
            return True
        else:
            print(f"✗ {test_name}: FAIL")
            print(f"  Original length: {len(list1)}")
            print(f"  Proposed length: {len(list2)}")
            
            # Show first few differences
            max_show = min(10, max(len(list1), len(list2)))
            for i in range(max_show):
                if i < len(list1) and i < len(list2):
                    if list1[i] != list2[i]:
                        print(f"  Diff at index {i}: '{list1[i]}' (ord {ord(list1[i])}) vs '{list2[i]}' (ord {ord(list2[i])})")
                elif i < len(list1):
                    print(f"  Original has extra at index {i}: '{list1[i]}' (ord {ord(list1[i])})")
                else:
                    print(f"  Proposed has extra at index {i}: '{list2[i]}' (ord {ord(list2[i])})")
            return False
    except Exception as e:
        print(f"✗ {test_name}: ERROR - {e}")
        return False

def run_tests():
    """Run comprehensive tests with different input types"""
    
    test_cases = [
        # Basic ASCII
        ("Empty string", ""),
        ("Single ASCII char", "A"),
        ("ASCII string", "Hello World"),
        ("ASCII with numbers", "Hello123"),
        ("ASCII special chars", "!@#$%^&*()"),
        
        # Unicode characters
        ("Unicode accents", "café naïve résumé"),
        ("Unicode symbols", "© ® ™ € £ ¥"),
        ("Unicode math", "α β γ δ ε π ∑ ∫ ∞"),
        ("Unicode arrows", "← → ↑ ↓ ↔ ⇐ ⇒"),
        
        # Different scripts
        ("Greek", "Αλφάβητο"),
        ("Cyrillic", "Алфавит"),
        ("Arabic", "أبجدية"),
        ("Chinese", "中文"),
        ("Japanese", "ひらがな カタカナ 漢字"),
        ("Korean", "한글"),
        
        # Emojis and high Unicode
        ("Simple emoji", "😀 😃 😄"),
        ("Complex emoji", "👨‍👩‍👧‍👦 🏳️‍🌈"),
        ("Mixed emoji text", "Hello 👋 World 🌍"),
        
        # Edge cases
        ("Whitespace", "   \t\n\r   "),
        ("Newlines", "Line1\nLine2\rLine3\r\n"),
        ("Quotes", '"Hello" \'World\''),
        ("Backslashes", "\\path\\to\\file"),
        
        # Longer strings
        ("Medium ASCII", "A" * 100),
        ("Medium Unicode", "π" * 100),
        ("Long mixed", "Hello World! " * 50 + "Unicode: αβγδε " * 25),
        
        # Zero-width and control characters
        ("Zero-width chars", "Hello\u200B\u200C\u200DWorld"),
        ("Control chars", "Start\u0001\u0002\u0003End"),
        
        # Surrogate pairs (high Unicode that requires UTF-16 surrogates)
        ("High Unicode", "𝐀𝐁𝐂 𝒜ℬ𝒞 𝔄𝔅ℭ"),
        ("Musical symbols", "𝄞 𝄢 𝄫 𝄪"),
        ("Emoji with surrogates", "🚀 🎯 🎨 🎭"),
        
        # Combination characters
        ("Combining chars", "e̊ å ñ ü"),
        ("Complex combining", "ọ̧̋̇̃̂"),
    ]
    
    print("Testing _reverse_strict_tostring implementations\n")
    print("=" * 60)
    
    passed = 0
    total = len(test_cases)
    
    for test_name, input_str in test_cases:
        try:
            original_result = original_reverse_strict_tostring(input_str)
            proposed_result = proposed_reverse_strict_tostring(input_str)
            
            if compare_sequences(original_result, proposed_result, test_name):
                passed += 1
        except Exception as e:
            print(f"✗ {test_name}: EXCEPTION - {e}")
    
    print("\n" + "=" * 60)
    print(f"Results: {passed}/{total} tests passed")
    
    if passed == total:
        print("🎉 All tests passed! The proposed implementation is correct.")
        return True
    else:
        print(f"❌ {total - passed} tests failed. The proposed implementation needs fixes.")
        return False

def performance_comparison():
    """Quick performance comparison between implementations"""
    import time
    
    print("\n" + "=" * 60)
    print("Performance Comparison")
    print("=" * 60)
    
    test_strings = [
        ("Short ASCII", "Hello World"),
        ("Medium Unicode", "Hello 世界 🌍" * 50),
        ("Long mixed", "Testing performance with mixed content: ASCII + Unicode αβγδε + Emoji 🚀" * 100),
    ]
    
    for test_name, test_str in test_strings:
        print(f"\nTesting: {test_name} (length: {len(test_str)})")
        
        # Original implementation
        start = time.perf_counter()
        for _ in range(1000):
            original_reverse_strict_tostring(test_str)
        original_time = time.perf_counter() - start
        
        # Proposed implementation  
        start = time.perf_counter()
        for _ in range(1000):
            proposed_reverse_strict_tostring(test_str)
        proposed_time = time.perf_counter() - start
        
        improvement = (original_time - proposed_time) / original_time * 100
        
        print(f"  Original: {original_time:.4f}s")
        print(f"  Proposed: {proposed_time:.4f}s")
        print(f"  Improvement: {improvement:.1f}%")

if __name__ == "__main__":
    success = run_tests()
    
    if success:
        performance_comparison()
    
    sys.exit(0 if success else 1)
