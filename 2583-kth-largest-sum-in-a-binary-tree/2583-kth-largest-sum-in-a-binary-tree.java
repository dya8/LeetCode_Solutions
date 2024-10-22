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
    public long kthLargestLevelSum(TreeNode root, int k)
     {
        if (root == null) return -1;

        // List to store sums of each level
        List<Long> levelSums = new ArrayList<>();
        
        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Perform level-order traversal (BFS)
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            // Add the sum of the current level to the list
            levelSums.add(levelSum);
        }
        
        // Sort the level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());
        
        // Check if we have enough levels
        if (k > levelSums.size()) {
            return -1;
        }
        
        // Return the kth largest level sum
        return levelSums.get(k - 1);
    }
}