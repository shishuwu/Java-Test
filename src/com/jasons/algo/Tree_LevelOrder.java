package com.jasons.algo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.jasons.datastruct.tree.TreeNode;

/**
 * <pre>
 *  Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

        Example :
        Given binary tree
        
            3
           / \
          9  20
            /  \
           15   7
        return its level order traversal as:
        
        [
          [3],
          [9,20],
          [15,7]
        ]
        Also think about a version of the question where you are asked to do a level 
        order traversal of the tree when depth of the tree is much greater than 
        number of nodes on a level.
 * 
 * </pre>
 * 
 * @author shishu
 */
public class Tree_LevelOrder {
    HashMap<Integer, ArrayList<Integer>> levelNodeMap = new HashMap<>();

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        travel(a, 0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> v : levelNodeMap.values()) {
            result.add(v);
        }
        return result;
    }

    public void travel(TreeNode node, int level) {

        if (node == null) {
            return;
        }
        level++;

        ArrayList<Integer> levelNodes = levelNodeMap.get(level);
        if (levelNodes == null) {
            levelNodes = new ArrayList<>();
            levelNodeMap.put(level, levelNodes);
        }
        levelNodes.add(node.val);

        travel(node.left, level);
        travel(node.right, level);
    }
    
    @Test
    public void test() throws Exception {
        TreeNode tree = TreeNode.get123Tree_1();
        System.out.println(new Tree_LevelOrder().levelOrder(tree));
    }
}
/**
 * My thought: Depth travel & Recursive
 * 
 */