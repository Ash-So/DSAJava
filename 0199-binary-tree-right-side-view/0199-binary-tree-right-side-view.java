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
        // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            TreeNode last = null;

            for(int i = 0 ; i < levelSize ; i++){
                TreeNode node = q.poll();
                if(node != null){
                    last = node;
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
            if(last != null){
                res.add(last.val);
            }
        }

        return res;
    }
}