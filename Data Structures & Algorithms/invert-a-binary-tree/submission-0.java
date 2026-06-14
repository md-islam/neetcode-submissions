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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }

    public TreeNode invertTreeHelper(TreeNode node) {
        if(node == null){return node;}
        
        //swap
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        invertTreeHelper(node.left);
        invertTreeHelper(node.right);
        return node;
    }
}
