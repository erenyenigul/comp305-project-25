package memoize;

import java.util.List;
import java.util.HashMap;

public class Memory<E> {
    HashMap<String, List<E>> memory = new HashMap<>();

    public void memoize(String word, List<E> items) {
        memory.put(word, items);
    }

    public boolean containsWord(String word) {
        return memory.containsKey(word);
    }

    public List<E> retrieve(String word) {
        return memory.get(word);
    }

}
