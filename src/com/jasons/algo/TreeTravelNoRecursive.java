package com.jasons.algo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <pre>
 * Given a binary tree, return the postorder traversal of its nodes’ values.
		
		Example :
		
		Given binary tree
		
		   1
		    \
		     2
		    /
		   3
		return [3,2,1].
		
		Using recursion is not allowed.
 * </pre>
 * 
 * @author shishu
 *
 */
public class TreeTravelNoRecursive {

	public ArrayList<Integer> postorderTraversal(TreeNode a) {
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		TreeNode node = a;
		stack.push(node);
		ArrayList<Integer> result = new ArrayList<>();

		while (!stack.isEmpty()) {

			node = stack.pop();
			stack2.push(node.val);
			
			
			if (node.left != null) {
				stack.push(node.left);
			}
			
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		
		while (!stack2.isEmpty()) {
			result.add(stack2.pop());
		}
		return result;
	}
}
