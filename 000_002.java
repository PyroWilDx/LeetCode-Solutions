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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode resultHead = result;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        boolean hasCarry = false;
        while (curr1 != null && curr2 != null) {
            hasCarry = handleNode(curr1, curr2, result, hasCarry);
            curr1 = curr1.next;
            curr2 = curr2.next;
            result = result.next;
        }

        ListNode dumpNode = new ListNode(0);

        while (curr1 != null) {
            hasCarry = handleNode(curr1, dumpNode, result, hasCarry);
            curr1 = curr1.next;
            result = result.next;
        }

        while (curr2 != null) {
            hasCarry = handleNode(dumpNode, curr2, result, hasCarry);
            curr2 = curr2.next;
            result = result.next;
        }

        if (hasCarry)
            result.next = new ListNode(1, null);

        return resultHead.next;
    }

    public boolean handleNode(ListNode curr1, ListNode curr2, ListNode result, boolean hasCarry) {
        int value = curr1.val + curr2.val;
        if (hasCarry)
            value++;
        hasCarry = false;

        if (value >= 10) {
            value -= 10;
            hasCarry = true;
        }

        result.next = new ListNode(value);

        return hasCarry;
    }
}
