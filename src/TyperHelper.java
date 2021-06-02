import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TyperHelper {

    TyperHelperAlgorithm algorithm;

    private HashSet<String> dict;

    public TyperHelper(TyperAlgorithmType algorithmType, HashSet<String> dict){
        this.dict = dict;
        switch (algorithmType){
            case BRUTE_FORCE:
                algorithm = new BruteForceTyperHelper(dict);
                break;
            case WORD_TREE:
                algorithm = new WordTreeTyperHelper(dict);
                break;
            case WORD_TREE_WITH_MEMO:
                algorithm = new WordTreeWithMemoizeTyperHelper(dict);
                break;
        }
    }

    public List<String> correct(String word, int operationLimit, int maxNumCorrections){
        if(dict.contains(word))
            return Arrays.asList(word);
        return algorithm.findCorrections(word, operationLimit, maxNumCorrections);
    }
}
