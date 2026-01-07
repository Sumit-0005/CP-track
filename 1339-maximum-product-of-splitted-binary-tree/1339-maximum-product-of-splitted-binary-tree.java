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
    private static final int MOD = 1000000007;
    private long ans = Long.MIN_VALUE;
    private long total = 0;
    private long dfs(TreeNode root){
        if(root == null) return 0;
        long sum = root.val +dfs(root.left) + dfs(root.right);
        ans = Math.max(ans , (total-sum)*sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        total = dfs(root);
        ans = Long.MIN_VALUE;
        dfs(root);
        return (int)(ans%MOD);
    }
}