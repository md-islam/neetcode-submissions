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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubTreeHelper(root, subRoot);
    }

    public boolean isSubTreeHelper(TreeNode node, TreeNode subRoot){
        if(node == null){
            return false;
        }
        if (isSameTreeHelper(node, subRoot)) {
            return true;
        }
        
        boolean leftSubTreeResult = isSubTreeHelper(node.left, subRoot);
        boolean rightSubTreeResult = isSubTreeHelper(node.right, subRoot);
        return leftSubTreeResult || rightSubTreeResult;
    }

    public boolean isSameTreeHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }        
        if (p == null || q == null) {
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTreeHelper(p.left, q.left) && isSameTreeHelper(p.right, q.right);
    }
}
