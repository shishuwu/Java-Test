package jasons.algo;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

import jasons.datastruct.tree.TreeNode;

/**
 * <pre>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path�s sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 * </pre>
 * 
 * @author shishu
 *
 */
public class SumTreeNum {

	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

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
	public static TreeNode initTree() {
		TreeNode root = new TreeNode(1);

		TreeNode x = new TreeNode(2);
		TreeNode y = new TreeNode(1);

		root.left = x;
		root.right = y;

		TreeNode z = new TreeNode(1);
		y.right = z;

		return root;
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

		Stack<TreeNode> stack = new Stack<>();

		TreeNode node = root;
		stack.push(node);

		ArrayList<Integer> travelPath = new ArrayList<>();
		int tempSum = 0;

		while (!stack.isEmpty()) {
			node = stack.pop();

			travelPath.add(node.val);
			tempSum += node.val;

			// leaf
			if (node.left == null && node.right == null) {
				if (tempSum == sum) {
					ArrayList<Integer> path = new ArrayList<>();
					path.addAll(travelPath);

					result.add(path);

					travelPath.remove(travelPath.size() - 1);
					tempSum -= node.val;
				}
			} else {
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
		return result;
	}

	@Test
	public void test() throws Exception {
		SumTreeNum test = new SumTreeNum();
		System.out.println(test.pathSum(initTree(), 3));
	}

	// =============
	public ArrayList<ArrayList<Integer>> pathSum2(TreeNode A, int B) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> array = new ArrayList<>();

		findAll(A, 0, B, res, array);

		return res;

	}

	public void findAll(TreeNode node, int curSum, int reqSum, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> array) {

		if (node == null)
			return;

		array.add(node.val);

		if (node.left == null && node.right == null) {
			curSum += node.val;

			if (curSum == reqSum) {
				res.add(new ArrayList(array));
			}

			array.remove(array.size() - 1);

			return;
		}

		curSum += node.val;

		findAll(node.left, curSum, reqSum, res, array);
		findAll(node.right, curSum, reqSum, res, array);

		array.remove(array.size() - 1);
	}
	
	@Test
	public void test2() throws Exception {
		SumTreeNum test = new SumTreeNum();
		System.out.println(test.pathSum2(initTree(), 3));
	}
}




/**
 * 
 * 
 */ 
