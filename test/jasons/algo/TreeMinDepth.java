package jasons.algo;

import org.junit.Test;

/**
 * <pre>
 * Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	
	NOTE : The path has to end on a leaf node.
	Example :
	
	         1
	        /
	       2
	min depth = 2.
 * </pre>
 * 
 * @author shishu
 */
public class TreeMinDepth {

	private int minDepth = Integer.MAX_VALUE;

	public int minDepth(TreeNode a) {
		travelDeptch(a, 0);
		return minDepth;
	}

	// mark the leaf:
	private void travelDeptch(TreeNode node, int depth) {
		if (node == null) {
			return;
		}

		depth++;

		// leaf
		if (node.left == null && node.right == null) {
			if (minDepth > depth) {
				minDepth = depth;
			}
			return;
		}

		if (node.left != null) {
			travelDeptch(node.left, depth);
		}

		if (node.right != null) {
			travelDeptch(node.right, depth);
		}

	}

	@Test
	public void test() throws Exception {
		TreeMinDepth test = new TreeMinDepth();
		System.out.println(test.minDepth(test.initTree()));
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * <pre>
	 * 
	 * 		1
	 *   2    1
	 * 			1
	 * </pre>
	 * 
	 * @return
	 */
	public TreeNode initTree() {
		TreeNode root = new TreeNode(1);

		TreeNode x = new TreeNode(2);
		TreeNode y = new TreeNode(1);

		root.left = x;
		root.right = y;

		TreeNode z = new TreeNode(1);
		y.right = z;

		return root;
	}
}
