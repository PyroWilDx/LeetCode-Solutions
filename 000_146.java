import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class ListNode {
        public int key;
        public int value;
        public ListNode prev;
        public ListNode next;
        
        public ListNode(int key, int value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = null;
        }

        public void removeSelf() {
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
        }
    }

    private ListNode head;
    private ListNode queue;
    private Map<Integer, ListNode> keyNodes;
    private int capacity;

    public LRUCache(int capacity) {
        this.head = null;
        this.queue = null;
        this.keyNodes = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyNodes.containsKey(key)) return -1;

        if (capacity == 1 || keyNodes.size() == 1) return keyNodes.get(key).value;

        ListNode node = keyNodes.get(key);
        if (head == node) return node.value;

        node.removeSelf();

        if (queue == node) {
            queue = node.prev;
        }

        node.prev = null;
        node.next = head;

        head.prev = node;
        head = node;

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 1) {
            keyNodes.clear();
            head = queue = keyNodes.put(key, new ListNode(key, value, null));
            return;
        }

        ListNode node = new ListNode(key, value, head);

        if (head == null && queue == null) {
            head = node;
            queue = node;
            keyNodes.put(key, node);
            return;
        }

        head.prev = node;
        head = node;

        if (!keyNodes.containsKey(key) && keyNodes.size() == capacity) {
            ListNode lastQueue = queue;
            queue = queue.prev;
            lastQueue.removeSelf();
            keyNodes.remove(lastQueue.key);
        } else if (keyNodes.containsKey(key)) {
            ListNode formerNode = keyNodes.get(key);
            
            if (queue == formerNode) {
                if (formerNode.prev != null) queue = formerNode.prev;
                else queue = head;
            }

            formerNode.removeSelf();
        }

        keyNodes.put(key, node);
    }
}
