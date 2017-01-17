package com.practice.basic.ds;

/**
 * Created by krishna.m1 on 27/11/16.
 */
public class BinarySearchTree {

    private class Node<E> {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node search(Node root, int data) {
        if(root == null || root.data == data) {
            return root;
        }

        if(data > root.data) {
            return search(root.right, data);
        }

        return search(root.left, data);
    }

    private Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data > root.data) {
            root.right = insert(root.right, data);
        } else if(data < root.data) {
            root.left = insert(root.left, data);
        }

        return root;
    }

    private void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    private boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.data < min || root.data > max) {
            return false;
        }

        return isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max);
    }


    private Node getInOrderSuccessor(Node root) {
        if(root.left == null) {
            return root;
        }
        return getInOrderSuccessor(root.left);
    }

    private Node deleteNode(Node root, int data) {
        if(root == null) {
            return root;
        }

        Node root1 = root;
        Node prev = null;
        while (true) {
            if(root == null) {
                return root1;
            }

            if(root.data == data) {
                break;
            }

            prev = root;
            if(data > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        if(root.left == null && root.right == null) {
            if(prev == null) {
                root = null;
                return root;
            } else {
                if(prev.data < data) {
                    prev.right = null;
                } else {
                    prev.left = null;
                }

                return root1;
            }
        } else if(root.left == null && root.right != null) {
            if(prev == null) {
                return root.right;
            } else {
                prev.left = root.right;
                return root1;
            }
        } else if(root.right == null && root.left != null) {
            if(prev == null) {
                return root.left;
            } else {
                prev.right = root.left;
                return root1;
            }
        } else {
            Node successor = getInOrderSuccessor(root.right);
            int tmp = successor.data;
            deleteNode(root1, successor.data);
            root.data = tmp;
            return root1;
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        Node root = null;
        root = bst.insert(root, 6);
        root = bst.insert(root, 2);
        root = bst.insert(root, 4);
        root = bst.insert(root, 3);
        root = bst.insert(root, 10);

        bst.inOrderTraversal(root);
        System.out.println("isBST : " + bst.isBST(root));

        root = bst.deleteNode(root, 6);
        root = bst.deleteNode(root, 10);
        root = bst.deleteNode(root, 4);
        root = bst.deleteNode(root, 2);

        System.out.println("----");
        bst.inOrderTraversal(root);

    }
}
