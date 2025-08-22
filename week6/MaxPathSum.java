package week6;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class MaxPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Get left and right max path, ignore negatives
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // Path including both children
        int currentPath = node.val + left + right;

        // Update global max
        maxSum = Math.max(maxSum, currentPath);

        // Return best one-side path
        return node.val + Math.max(left, right);
    }
}
class max_path_sum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum solver = new MaxPathSum();
        System.out.println(solver.maxPathSum(root));
    }
    
}
