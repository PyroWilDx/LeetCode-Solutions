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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int n = getListNodeSize(head);
        k = k % n;
        if (k == 0) {
            return head;
        }

        int targetIndex = n - k - 1;
        ListNode targetNode = head;
        int i = 0;
        while (i < targetIndex) {
            targetNode = targetNode.next;
            i++;
        }

        ListNode newHead = targetNode.next;
        targetNode.next = null;
        ListNode curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }

    public int getListNodeSize(ListNode head) {
        int result = 0;
        ListNode curr = head;
        while (curr != null) {
            result++;
            curr = curr.next;
        }
        return result;
    }
}
