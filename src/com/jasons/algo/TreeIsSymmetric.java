package com.jasons.algo;

import java.util.ArrayList;

import com.jasons.datastruct.tree.TreeNode;

/**
 * <pre>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

		Example :
		
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		The above binary tree is symmetric. 
		But the following is not:
		
		    1
		   / \
		  2   2
		   \   \
		   3    3
		Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * </pre>
 * 
 * @author shishu
 *
 */
public class TreeIsSymmetric {

	ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public int isSymmetric(TreeNode a) {
		travelTree(a, new ArrayList<>());

		for (int i = 0; i < list.size() / 2; i++) {
			String left = list.get(i).toString();
			String right = list.get(list.size() - 1 - i).toString();
			if (!left.equals(right)) {
				return 0;
			}
		}
		return 1;
	}

	private void travelTree(TreeNode a, ArrayList<Integer> tmpPath) {
		if (a == null) {
			return;
		}
		ArrayList<Integer> path = new ArrayList<>();
		path.addAll(tmpPath);
		path.add(a.val);

		// this is leaf
		if (a.left == null && a.right == null) {
			list.add(path);
			return;
		}

		if (a.left != null) {
			travelTree(a.left, path);
		}

		if (a.right != null) {
			travelTree(a.right, path);
		}
	}

	// =============MORE EFFICIENT=======================

	public int isSymmetric2(TreeNode A) {

		if (A == null)
			return 0;

		return rec(A.left, A.right) ? 1 : 0;

	}

	public boolean rec(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null)
			return false;

		if (node1.val != node2.val)
			return false;

		return rec(node1.left, node2.right) | rec(node1.right, node2.left);

	}
}

/**
 * Thought: Tree travel. track each root-leaf path, record them in list. Then
 * compare symmetric
 */
