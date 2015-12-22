package com.jasons.datastruct.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 
 * @author Jason Shi 10:28:19 AM
 * @since HPDM 4.7.1
 */
public class TreeTest {

    class TreeNode {
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode left;
        TreeNode right;
    }
    
    /**
     * No recursive loop tree nodes
     * 
     * parent -> right -> left
     * 
     * @param root
     * @return
     */
    public List<Integer> travelNoRecursive(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return result;
    }

    /**
     * Recursive loop tree nodes
     * 
     * @param node
     * @param result
     * @return
     */
    public List<Integer> travelRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return Collections.emptyList();
        }
        result.add(node.val);
        travelRecursive(node.right, result);
        travelRecursive(node.left, result);
        return result;
    }

    /**
     * <pre>
     *           1
     *              2
     *           3    4   
     * </pre>
     * @return
     */
    private TreeNode initTree() {
        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        TreeNode four = new TreeNode(4);
        
        
        root.right = two;
        two.left = three;
        
        two.right = four;
        

        return root;
    }

    public static void main(String[] args) {
        TreeTest test = new TreeTest();
        TreeNode root = test.initTree();
        System.out.println(test.travelNoRecursive(root));

        List<Integer> result = new ArrayList<>();
        test.travelRecursive(root, result);
        System.out.println(result);
    }
}
