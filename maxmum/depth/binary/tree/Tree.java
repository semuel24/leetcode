package maxmum.depth.binary.tree;

public class Tree {

	public int maxDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
