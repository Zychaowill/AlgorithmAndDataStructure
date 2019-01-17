package com.buildupchao.datastructure.basic.tree.rb;

/**
 * Created by yachao on 18/2/15.
 */
public class RBNode {
    RBNode parent;
    RBNode left;
    RBNode right;
    int value;
    RBColor color;

    public static RBNode leftRotate(RBNode root, RBNode node) {
        if (node.right == nullNode)
            return root;

        RBNode right = node.right;
        node.right = right.left;
        if (node.right != nullNode)
            node.right.parent = node;
        if (node.parent != nullNode) {
            right.parent = node.parent;
            if (node.parent.left == node)
                node.parent.left = right;
            else
                node.parent.right = right;
        } else {
            root = right;
            root.parent = nullNode;
        }
        right.left = node;
        node.parent = right;
        return root;
    }

    public static RBNode rightRotate(RBNode root, RBNode node) {
        if (node.left == nullNode)
            return root;

        RBNode left = node.left;
        node.left = left.right;
        if (node.left != nullNode)
            node.left.parent = node;
        if (node.parent != nullNode) {
            left.parent = node.parent;
            if (node.parent.left == node)
                node.parent.left = left;
            else
                node.parent.right = left;
        } else {
            root = left;
            node.parent = nullNode;
        }
        left.right = node;
        node.parent = left;
        return root;
    }

    public static RBNode rbInsert(RBNode root, RBNode insertNode) {
        RBNode position = root;
        RBNode parent = nullNode;

        while (position != nullNode) {
            parent = position;
            if (insertNode.value < position.value)
                position = position.left;
            else if (insertNode.value > position.value)
                position = position.right;
        }

        insertNode.parent = parent;
        if (parent == nullNode)
            root = insertNode;
        else if (insertNode.value < parent.value)
            parent.left = insertNode;
        else if (insertNode.value > parent.value)
            parent.right = insertNode;
        insertNode.color = RBColor.RED;
        return rbInsertFixUp(root, insertNode);
    }

    public static RBNode rbInsertFixUp(RBNode root, RBNode node) {
        RBNode parent = root.parent;
        RBNode grandParent;
        RBNode parentBrother;

        while (parent != nullNode && parent.color == RBColor.RED) {
            grandParent = parent.parent;
            if (grandParent.left == parent) {
                parentBrother = grandParent.right;
                if (parentBrother != nullNode && parentBrother.color == RBColor.RED) {
                    grandParent.color = RBColor.RED;
                    parent.color = RBColor.BLACK;
                    parentBrother.color = RBColor.BLACK;
                    node = grandParent;
                } else {
                    if (parent.right == node) {
                        root = leftRotate(root, parent);
                        RBNode temp = node;
                        node = parent;
                        parent = temp;
                    }
                    grandParent.color = RBColor.RED;
                    parent.color = RBColor.BLACK;
                    root = rightRotate(root, grandParent);
                    node = root;
                }
            } else {
                parentBrother = grandParent.left;
                if (parentBrother != nullNode && parentBrother.color == RBColor.RED) {
                    grandParent.color = RBColor.RED;
                    parent.color = RBColor.BLACK;
                    parentBrother.color = RBColor.BLACK;
                    node = grandParent;
                } else {
                    if (parent.left == node) {
                        root = rightRotate(root, parent);
                        RBNode temp = node;
                        node = parent;
                        parent = temp;
                    }
                    grandParent.color = RBColor.RED;
                    parent.color = RBColor.BLACK;
                    root = leftRotate(root, grandParent);
                    node = root;
                }
            }
            parent = node.parent;
        }
        root.color = RBColor.BLACK;
        return root;
    }

    public static RBNode rbDelete(RBNode root, RBNode deleteNode) {
        RBNode replaceNode, fixNode = nullNode;
        RBNode fixNodeParent = deleteNode.parent;
        RBColor deleteColor = deleteNode.color;

        if (deleteNode.left == nullNode && deleteNode.right == nullNode) {
            replaceNode = nullNode;
        } else if (deleteNode.right == nullNode) {
            replaceNode = deleteNode.left;
            fixNode = replaceNode;
        } else if (deleteNode.left == nullNode) {
            replaceNode = deleteNode.right;
            fixNode = replaceNode;
        } else {
            replaceNode = deleteNode.right;
            while (replaceNode.left != nullNode)
                replaceNode = replaceNode.left;
            fixNode = replaceNode.right;

            // to be done...
        }
        return root;
    }

    public static RBNode rbDeleteFixUp(RBNode root, RBNode node) {

        return root;
    }

    static final RBNode nullNode = new RBNode() {
        {
            color = RBColor.BLACK;
        }

        public String toString() {
            return "(null" + color + ")";
        }
    };
}
