import java.util.*;

public class TyperHelper {

    TyperHelperAlgorithm algorithm;

    public TyperHelper(TyperAlgorithmType algorithmType, HashSet<String> dict){
        long initialTime = new Date().getTime();
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
        System.out.printf("Initialized algorithm in %d milliseconds.\n", new Date().getTime() - initialTime);
    }

    public List<String> correct(String word, int operationLimit, int maxNumCorrections){
        if(algorithm.dict.contains(word.toLowerCase())) {
            return new ArrayList<String>(Arrays.asList(word));
        }
        return algorithm.findCorrections(word, operationLimit, maxNumCorrections);
    }
}
