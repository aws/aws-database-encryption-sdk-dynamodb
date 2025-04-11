import sys
"""
DBESDK's Dafny code parses the TestVectors JSON recursively.
i.e. GetTests(Json) = (Json[0], GetTests(Json[1:]))
The decrypt_X_33a.json file has 2832 test vectors.
By default, Python has a recursion limit of 1000.
DBESDK exceeds Python's recursion limit when parsing the JSON, which needs >1 call per test vector.
(Other Crypto Tools languages are limited by memory; Python's explicit limit on function calls is unique.)
When using this internal Crypto Tools TestVectors library, set recursion limit to 10,000.
(This value is totally arbitrary and should be increased if this isn't enough.)
"""
sys.setrecursionlimit(10000)

# Initialize generated Dafny
from .internaldafny.generated import module_

# Initialize externs
from .internaldafny import extern
