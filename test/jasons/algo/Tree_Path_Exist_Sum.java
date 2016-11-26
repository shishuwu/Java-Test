package jasons.algo;

import jasons.datastruct.tree.TreeNode;

/**
 * <pre>
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
		
		Example :
		
		Given the below binary tree and sum = 22,
		
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
		return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
		
		Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * </pre>
 * 
 * @author shishu
 */
public class Tree_Path_Exist_Sum {

	int exist = 0;
	int sum;
	int expected;

	public int hasPathSum(TreeNode a, int b) {
		expected = b;

		travelTreeRecursive(a, b);
		return exist;
	}

	/**
	 * Use recursive: code is simple, but when find the result, it won't stop!!!
	 * 
	 * @param node
	 * @param sum
	 */
	private void travelTreeRecursive(TreeNode node, int sum) {
		sum += node.val;
		// leaf
		if (node.left == null && node.right == null) {
			if (sum == expected) {
				expected = 1;
				return;
			}
		}

		if (node.left != null) {
			travelTreeRecursive(node.left, sum);
		}

		if (node.right != null) {
			travelTreeRecursive(node.right, sum);
		}
	}

	// private void travelTreeWithoutRecursive(TreeNode root) {
	//
	// Stack<TreeNode> stack = new Stack<>();
	// TreeNode node = root;
	//
	// stack.push(node);
	//
	//
	// while (!stack.isEmpty()) {
	// node = stack.pop();
	// sum += node.val;
	// if (node.left == null && node.right == null) {
	// if (sum == expected) {
	// exist = 1;
	// break;
	// }
	// sum -= node.val;
	// }
	//
	// if (node.left != null) {
	// stack.push(node.left);
	// }
	// if (node.right != null) {
	// stack.push(node.right);
	// }
	// }
	// }
}
