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
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode a = q.remove();
                arr.add(a.val);
                if(a.left!=null) q.add(a.left);
                if(a.right!=null) q.add(a.right);
            }
            list.add(arr);
        }
        return list;
    }
}