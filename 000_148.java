import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            nodes.add(currNode);
            currNode = currNode.next;
        }
        nodes.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        ListNode resultHead = nodes.get(0);
        currNode = resultHead;
        int i = 1;
        while (i < nodes.size()) {
            ListNode nextNode = nodes.get(i);
            currNode.next = nextNode;
            currNode = nextNode;
            i++;
        }
        currNode.next = null;
        return resultHead;
    }
}
