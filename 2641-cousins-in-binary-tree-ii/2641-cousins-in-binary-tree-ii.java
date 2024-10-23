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
class Solution
 {
    public TreeNode replaceValueInTree(TreeNode root) 
    {
         if (root == null) return null;

        // Queue for level order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Set root value to 0 as it has no cousins
        root.val = 0;
        
        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            
            // A list to hold the current level's nodes
            List<TreeNode> levelNodes = new ArrayList<>();
            
            // First pass: Collect all nodes of the current level and calculate level sum
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);
                
                // Calculate total sum of the level (using original values)
                if (node.left != null) {
                    levelSum += node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    levelSum += node.right.val;
                    queue.offer(node.right);
                }
            }

            // Second pass: Modify each node's value based on the cousin sum
            for (TreeNode node : levelNodes) {
                int siblingSum = 0;
                
                // If the node has both left and right children, calculate their sibling sum
                if (node.left != null && node.right != null) {
                    siblingSum = node.left.val + node.right.val;
                    node.left.val = levelSum - siblingSum;
                    node.right.val = levelSum - siblingSum;
                }
                
                // If the node has only left child
                else if (node.left != null) {
                    node.left.val = levelSum - node.left.val;
                }
                
                // If the node has only right child
                else if (node.right != null) {
                    node.right.val = levelSum - node.right.val;
                }
            }
        }

        return root;
        
    }
}