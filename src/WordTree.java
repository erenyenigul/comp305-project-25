import java.util.*;
import java.util.stream.Collectors;

public class WordTree {

    private Node root;

    public WordTree(){
        root=null;
    }

    public WordTree(HashSet<String> set){
        for(String word: set)
            insert(word);
    }

    private class Node{
        private String value;
        private HashMap<Integer, Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        public String getValue(){
            return value;
        }

        public void addChild(int weight, Node n){
            children.put(weight, n);
        }

        public Node getChildWithWeight(int weight){
            return children.get(weight);
        }

        public HashMap<Integer, Node> getChildrenEdges(){
            return children;
        }

        public Set<Integer> getEdgeWeights(){
            return children.keySet();
        }

        public Collection<Node> getChildren(){
            return children.values();
        }
    }

    public void insert(String word){
        if(root == null)
            root = new Node(word);

        else
            recInsert(word, root);
    }

    private void recInsert(String word, Node current){
        int dist = Utils.strDistance(word, current.getValue());

        Node collision = current.getChildWithWeight(dist);
        if(collision != null){
            recInsert(word, collision);
        }else{
            current.addChild(dist, new Node(word));
        }
    }

    public boolean contains(String word){
        return recContains(root, word);
    }

    private boolean recContains(Node current, String word){
        if(current.getValue().equals(word)){
            for(Integer i: current.getChildrenEdges().keySet()) {
               System.out.println( i + " "+ current.getChildrenEdges().get(i).getValue());
            }
            return true;
        }

        boolean contains = false;
        for(Node n: current.getChildren()) {
            contains |= recContains(n, word);
        }
        return contains;
    }

    public List<String> findSimilar(String word, int limOperations){
        HashMap<String, Integer> corrections = new HashMap<>();
        recSimilar(word, limOperations, root, corrections);

        return corrections.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private void recSimilar(String word, int limOperations, Node current, HashMap<String, Integer> corrections){
        int dist = Utils.strDistance(word, current.getValue());

        if(dist <= limOperations)
            corrections.put(current.getValue(), dist);

        for(Integer w: current.getEdgeWeights()){
            if(w<=dist+limOperations && w>=dist-limOperations)
                recSimilar(word, limOperations, current.getChildWithWeight(w), corrections);
        }
    }
}
