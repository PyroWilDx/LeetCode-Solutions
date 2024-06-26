class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list2.val < list1.val) {
            ListNode list = list1;
            list1 = list2;
            list2 = list;
        }

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while (curr1.next != null && curr2 != null) {
            if (curr1.next.val < curr2.val) {
                curr1 = curr1.next;
            } else {
                ListNode nextCurr1 = curr1.next;
                ListNode nextCurr2 = curr2.next;
                curr1.next = curr2;
                curr2.next = nextCurr1;
                curr2 = nextCurr2;
            }
        }

        if (curr2 != null) {
            curr1.next = curr2;
        }

        return list1;
    }
}