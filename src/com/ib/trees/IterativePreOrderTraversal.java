package com.ib.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by krishna.m1 on 11/12/16.
 */
public class IterativePreOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        if(a == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(a);

        while(!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if(treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if(treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

        return list;
    }

    public static void main(String args[]) {

    }
}
