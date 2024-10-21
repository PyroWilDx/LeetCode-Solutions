class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRec(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTRec(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }

        int m = (i + j) / 2;
        int num = nums[m];
        TreeNode node = new TreeNode(num);
        node.left = sortedArrayToBSTRec(nums, i, m - 1);
        node.right = sortedArrayToBSTRec(nums, m + 1, j);
        return node;
    }
}
