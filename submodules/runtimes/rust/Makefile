build:
	./build.sh

diff:
	diff dafny_impl/src/ImplementationFromDafny.rs ImplementationFromDafny-rust/src/ImplementationFromDafny.rs | grep -E '^[<>]'| wc -l
