import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordTreeTyperHelper extends TyperHelperAlgorithm{

    private WordTree tree;

    public WordTreeTyperHelper(HashSet<String> dict) {
        super(dict);
        this.tree = new WordTree(dict);
    }

    @Override
    public List<String> findCorrections(String word, int limOperations, int maxNumCorrections) {
        return tree.findSimilar(word, limOperations)
                   .stream()
                   .limit(maxNumCorrections)
                   .collect(Collectors.toList());
    }
}
