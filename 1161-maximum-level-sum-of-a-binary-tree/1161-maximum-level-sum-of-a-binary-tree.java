/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxIdx = 1;
        int maxSum = root.val;
        int currIdx = 0;

        while (!q.isEmpty()) {
            currIdx++;
            int n = q.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxIdx = currIdx;
            }
        }
        return maxIdx;
    }
}