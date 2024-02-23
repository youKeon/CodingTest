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
    int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        dfs(root, false);
        return ans;
    }
    
    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (isLeft && isLeafNode(root)) ans += root.val;
        dfs(root.left, true);
        dfs(root.right, false);
    }
    
    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}