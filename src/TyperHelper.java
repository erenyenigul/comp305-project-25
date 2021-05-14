import java.util.HashSet;
import java.util.List;

public class TyperHelper {

    TyperHelperAlgorithm algorithm;

    public TyperHelper(TyperAlgorithmType algorithmType, HashSet<String> dict){
        switch (algorithmType){
            case BRUTE_FORCE:
                algorithm = new BruteForceTyperHelper(dict);
                break;
            case WORD_TREE:
                algorithm = new WordTreeTyperHelper(dict);
                break;
        }
    }

    public List<String> correct(String word, int operationLimit, int maxNumCorrections){
        return algorithm.findCorrections(word, operationLimit, maxNumCorrections);
    }
}
