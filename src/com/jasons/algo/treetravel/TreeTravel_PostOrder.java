package com.jasons.algo.treetravel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import com.jasons.datastruct.tree.TreeNode;

/**
 * <pre>
 * Given a binary tree, return the postorder 后序：左右中 traversal of its nodes’ values.
		
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
public class TreeTravel_PostOrder {

    // no recursive
	public ArrayList<Integer> travel_NoRecur(TreeNode a) {
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
	
    // ======================================
    List<Integer> result2 = new ArrayList<>();

    /**
     * Use Recursion is always the easiest way to travel tree.
     * 
     * @param a
     */
    public void travel_Recursive(TreeNode a) {
        if (a == null) {
            return;
        }

        travel_Recursive(a.left);
        travel_Recursive(a.right);
        result2.add(a.val);
    }
    // =====================================
    
    @Test
    public void test() throws Exception {
        TreeTravel_PostOrder test = new TreeTravel_PostOrder();
        TreeNode tree = TreeNode.get123Tree_1();
        
        System.out.println(test.travel_NoRecur(tree));
        
        test.travel_Recursive(tree);
        System.out.println(test.result2);
    }
}
