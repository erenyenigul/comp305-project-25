import java.util.HashSet;
import java.util.List;

public abstract class TyperHelperAlgorithm {
    HashSet<String> dict;
    public TyperHelperAlgorithm(HashSet<String> dict) {
        this.dict = dict;
    }

    public abstract List<String> findCorrections(String word, int operationLimit, int maxNumCorrections);
}
