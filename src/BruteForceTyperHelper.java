import java.util.*;
import java.util.stream.Collectors;

public class BruteForceTyperHelper extends TyperHelperAlgorithm{

    private HashMap<String, ArrayList<WeightedItem>> memory = new HashMap<>();

    private class WeightedItem implements Comparable<WeightedItem> {
        public int weight;
        public String searchWord;
        public String result;
        public WeightedItem(int weight, String searchWord, String result) {
            this.weight = weight;
            this.searchWord = searchWord;
            this.result = result;
        }


        @Override
        public int compareTo(WeightedItem o) {
            return this.weight - o.weight;
        }

        @Override
        public int hashCode() {
            return this.weight + this.searchWord.hashCode() + this.result.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }
    }

    public BruteForceTyperHelper(HashSet<String> dict) {
        super(dict);
    }

    @Override
    public List<String> findCorrections(String word, int operationLimit, int maxNumCorrections) {
        if(memory.containsKey(word)) { // If we already calculated the given word
            return memory.get(word).stream()
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
        this.memory.put(word, toMemorize);
        return this.findCorrections(word, operationLimit, maxNumCorrections);
    }
}
