package Utils;

public class constants {
    public static dafny.DafnySequence<? extends Character> getDefaultKeys(){
        return dafny.DafnySequence.asString("../../../submodules/MaterialProviders/TestVectorsAwsCryptographicMaterialProviders/dafny/TestVectorsAwsCryptographicMaterialProviders/test/keys.json");
    }
}
