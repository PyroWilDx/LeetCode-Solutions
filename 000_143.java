class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = slow.next;
        ListNode next1 = null;
        while (p != null) {
            ListNode next2 = p.next;
            p.next = next1;
            next1 = p;
            p = next2;
        }

        slow.next = null;

        ListNode start = head;
        ListNode end = next1;
        while (end != null) {
            ListNode startNext = start.next;
            ListNode endNext = end.next;
            start.next = end;
            start.next.next = startNext;
            start = startNext;
            end = endNext;
        }
    }
}
