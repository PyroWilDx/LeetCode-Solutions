import java.util.HashMap;
import java.util.Map;

class Solution {
    public class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> originalCopiedMap = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            originalCopiedMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copied = originalCopiedMap.get(curr);
            copied.next = originalCopiedMap.get(curr.next);
            copied.random = originalCopiedMap.get(curr.random);
            curr = curr.next;
        }

        return originalCopiedMap.get(head);
    }
}