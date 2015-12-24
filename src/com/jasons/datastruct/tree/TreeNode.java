package com.jasons.datastruct.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * Generate 123 tree as following
     * <pre>
     *
     * 
            1
            \
             2
            /
            3
     * </pre>
     * 
     * @return
     */
    public static TreeNode get123Tree_1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        
        n1.right = n2;
        n2.left = n3;
        
        return n1;
    }
}
