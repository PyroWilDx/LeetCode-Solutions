class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.addNextNode(word.charAt(i));
        }
        curr.setIsEndingTrue();
    }
    
    public boolean search(String word) {
        return searchRec(root, 0, word);
    }

    private boolean searchRec(Node curr, int index, String word) {
        if (index == word.length()) {
            return curr.isEnding;
        }

        char value = word.charAt(index);
        if (value == '.') {
            boolean result = false;
            for (Node nextNode : curr.getNextNodes()) {
                if (nextNode == null) continue;

                result = result || searchRec(nextNode, index + 1, word);
            }
            return result;
        }
        Node nextNode = curr.getNextNode(value);
        return (nextNode != null) && searchRec(nextNode, index + 1, word);
    }

    private class Node {
        private Node[] nextNodes;
        public boolean isEnding;

        public Node() {
            this.nextNodes = new Node[26];
            this.isEnding = false;
        }

        public void setIsEndingTrue() {
            this.isEnding = true;
        }

        public Node addNextNode(char nextValue) {
            int index = nextValue - 'a';
            Node nextNode = nextNodes[index];
            if (nextNode == null) {
                nextNode = new Node();
                nextNodes[index] = nextNode;
            }
            return nextNode;
        }

        public Node getNextNode(char nextValue) {
            return nextNodes[nextValue - 'a'];
        }

        public Node[] getNextNodes() {
            return nextNodes;
        }
    }
}
