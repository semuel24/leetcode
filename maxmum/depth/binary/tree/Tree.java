package maxmum.depth.binary.tree;

import tree.common.TreeNode;

public class Tree {

	int maxH = 0;
	public int maxDepth(TreeNode root) {
//		return recursive(root);
		
		if(root == null) {
			return 0;
		}
		int h = 1;
		dfs(root, h);
		return maxH;
    }
	
	
	private void dfs(TreeNode root, int h) {
		
		if(h > maxH) {
			maxH = h;
		}
		
		if(root.left != null) {
			dfs(root.left, h+1);
		}
		
		if(root.right != null) {
			dfs(root.right, h+1);
		}
	}
	
	
	private int recursive(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(recursive(root.left), recursive(root.right));
	}
	
	
}


