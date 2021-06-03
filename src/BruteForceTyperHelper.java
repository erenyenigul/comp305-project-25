import memoize.Memory;
import memoize.WeightedItem;
import utils.Utils;

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
        ArrayList<WeightedItem> toMemoize = new ArrayList<WeightedItem>();
        for(String correct : this.dict) {
            int minOperations = Utils.strDistance(word, correct);
            WeightedItem toAdd = new WeightedItem(minOperations, word, correct);
            toMemoize.add(toAdd);
        }

        Collections.sort(toMemoize);
        this.memory.memoize(word, toMemoize);
        return this.findCorrections(word, operationLimit, maxNumCorrections);
    }
}
