import memoize.Memory;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordTreeWithMemoizeTyperHelper extends TyperHelperAlgorithm {
    private WordTree tree;

    public WordTreeWithMemoizeTyperHelper(HashSet<String> dict) {
        super(dict);
        this.tree = new WordTree(dict);
    }

    Memory<String> memory = new Memory<>();

    @Override
    public List<String> findCorrections(String word, int limOperations, int maxNumCorrections) {
        if(this.memory.containsWord(word)) {
            return this.memory.retrieve(word);
        }
        List<String> result = tree.findSimilar(word, limOperations)
                .stream()
                .limit(maxNumCorrections)
                .collect(Collectors.toList());
        memory.memoize(word, result);
        return result;
    }
}

