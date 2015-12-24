package com.jasons.algo.treetravel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jasons.datastruct.tree.TreeNode;

/**
 * <pre>
 * Given a binary tree, return the <b>inorder(中序) left -> mid -> right</b> traversal of its nodes’ values.
        
        Example :
        Given binary tree
        
           1
            \
             2
            /
           3
        return [1,3,2].
        
        Using recursion is not allowed.
 * </pre>
 */
public class TreeTravel_InOrder {

    public ArrayList<Integer> travel_NoRecur(TreeNode a) {
        TreeNode current, node;
        ArrayList<Integer> res = new ArrayList<>();
        current = a;

        while (current != null) {
            // no left
            if (current.left == null) {
                res.add(current.val);
                current = current.right;
            }
            // left
            else {
                node = current.left;
                while (node.right != null && !current.equals(node.right)) {
                    node = node.right;
                }
                if (node.right == null) {
                    node.right = current;
                    current = current.left;
                }
                else {
                    current = node.right;
                    node.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
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
        result2.add(a.val);
        travel_Recursive(a.right);
    }
    // =====================================

    @Test
    public void test() throws Exception {
        TreeNode tree = TreeNode.get123Tree_1();
        TreeTravel_InOrder test = new TreeTravel_InOrder();

        System.out.println(test.travel_NoRecur(tree));

        test.travel_Recursive(tree);
        System.out.println(test.result2);
    }

}
