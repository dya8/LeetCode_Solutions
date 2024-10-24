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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) 
    {
         // Base case: both nodes are null
        if (root1 == null && root2 == null) {
            return true;
        }
        // If one of the nodes is null or their values don't match, return false
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        
        // Recursively check for both flip and non-flip conditions
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        // Return true if either noFlip or flip condition is satisfied
        return noFlip || flip;
    }
}