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
    Set<Integer> set;
    int k;
    public boolean findTarget(TreeNode root, int k) {
        this.set = new HashSet<>();

        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        
        return dfs(root.left, k) || dfs(root.right, k);
    }
}