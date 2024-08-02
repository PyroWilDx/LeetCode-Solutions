import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Trie {
    private Node head;
    private Set<String> words;

    public Trie() {
        this.head = new Node();
        this.words = new HashSet<>();
    }

    public void insert(String word) {
        Node curr = head;
        for (int i = 0; i < word.length(); i++) {
            char value = word.charAt(i);
            Node nextNode = curr.getNextNode(value);
            if (nextNode == null) {
                nextNode = curr.addNextNode(value);
            }
            curr = nextNode;
        }

        words.add(word);
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        if (words.contains(prefix)) return true;

        Node curr = head;
        for (int i = 0; i < prefix.length(); i++) {
            char value = prefix.charAt(i);
            Node nextNode = curr.getNextNode(value);
            if (nextNode == null) {
                return false;
            }
            curr = nextNode;
        }
        return true;
    }

    private class Node {
        public Map<Character, Node> nextNodes;
    
        public Node() {
            this.nextNodes = new HashMap<>();
        }

        public Node addNextNode(char nextValue) {
            Node nextNode = new Node();
            nextNodes.put(nextValue, nextNode);
            return nextNode;
        }

        public Node getNextNode(char nextValue) {
            return nextNodes.get(nextValue);
        }
    }
}
