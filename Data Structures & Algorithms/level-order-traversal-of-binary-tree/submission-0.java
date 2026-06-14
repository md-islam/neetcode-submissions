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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> tracker = new LinkedList<TreeNode>();
        tracker.add(root);
        while(tracker.size() != 0) {
            int levelSize = tracker.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = tracker.remove();
                if (currentNode.left != null) {
                    tracker.add(currentNode.left);
                };
                if (currentNode.right != null) {
                    tracker.add(currentNode.right);
                };
                level.add(currentNode.val);
            }
            result.add(level);
        }
        return result;
    }
}
