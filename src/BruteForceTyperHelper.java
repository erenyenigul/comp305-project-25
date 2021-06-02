import memoize.Memory;
import memoize.WeightedItem;

import java.util.*;
import java.util.stream.Collectors;

public class BruteForceTyperHelper extends TyperHelperAlgorithm {

    public BruteForceTyperHelper(HashSet<String> dict) {
        super(dict);
    }
    Memory<WeightedItem> memory = new Memory<>();

    @Override
    public List<String> findCorrections(String word, int operationLimit, int maxNumCorrections) {
        if(memory.containsWord(word)) { // If we already calculated the given word
            return memory.retrieve(word).stream()
                    .filter(s -> s.weight <= operationLimit)
                    .limit(maxNumCorrections)
                    .map(s -> s.result).collect(Collectors.toList());
        }
        ArrayList<WeightedItem> toMemorize = new ArrayList<WeightedItem>();
        for(String correct : this.dict) {
            int minOperations = Utils.strDistance(word, correct);
            WeightedItem toAdd = new WeightedItem(minOperations, word, correct);
            toMemorize.add(toAdd);
        }

        Collections.sort(toMemorize);
        this.memory.memoize(word, toMemorize);
        return this.findCorrections(word, operationLimit, maxNumCorrections);
    }
}
