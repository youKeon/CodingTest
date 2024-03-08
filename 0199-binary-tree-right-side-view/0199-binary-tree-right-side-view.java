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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        q.add(root);
        if (root == null) {
            return ans;
        }
        
        while (!q.isEmpty()) {
            int len = q.size();    
            TreeNode tmp = null;
            
            for (int i = 0; i < len; i++) {
                tmp = q.poll();
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            ans.add(tmp.val);
        }
        return ans;
    }
}