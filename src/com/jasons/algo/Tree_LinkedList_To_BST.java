package com.jasons.algo;

import java.util.ArrayList;

import com.jasons.datastruct.linkedlist.ListNode;
import com.jasons.datastruct.tree.TreeNode;

/**
 * 
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * <pre>
        A height balanced BST : a height-balanced binary tree is defined as a binary tree 
        in which the depth of the two subtrees of every node never differ by more than 1.
        
        Example :
        
        
        Given A : 1 -> 2 -> 3
        A height balanced BST  :
        
              2
            /   \
           1     3
 * </pre>
 * 
 * @author shishu
 *
 */
public class Tree_LinkedList_To_BST {

//    public TreeNode sortedListToBST(ListNode head) {
//        int length = 0;
//        ListNode node = head;
//        while (node != null) {
//            node = node.next;
//            length++;
//        }
//        return sortedListToBST(head, length);
//    }
//
//    private TreeNode sortedListToBST(ListNode head, int length) {
//        if (length == 0 || head == null) {
//            return null;
//        }
//        else if (length == 1) {
//            return new TreeNode(head.val);
//        }
//
//        ListNode peak = head;
//        int index = (int) (length / 2);
//        for (int i = 0; i < index; i++) {
//            peak = peak.next;
//        }
//
//        TreeNode node = new TreeNode(peak.val);
//        node.left = sortedListToBST(head, index);
//        node.right = sortedListToBST(peak.next, length - index - 1);
//
//        return node;
//    }

    // ======================================================
    private ArrayList<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST2(ListNode linkedList) {
        ListNode node = linkedList;
        int len = 0;
        while (node != null) {
            list.add(node.val);

            node = node.next;
            len++;
        }
        return buildTree(0, len - 1);
    }

    public TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(list.get(start));
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildTree(start, mid - 1);
        node.right = buildTree(mid + 1, end);
        return node;
    }
}

/**
 * Brute force : Find the middle of the list, make it the root. Left part of the
 * tree comes from the first half and right part of the tree comes from the
 * later half.
 * 
 * Can you think of making it better ? Note that you can construct the left tree
 * first by passing the size of the left tree that you expect.
 */
