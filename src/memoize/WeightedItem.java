package memoize;

public class WeightedItem implements Comparable<WeightedItem> {
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
