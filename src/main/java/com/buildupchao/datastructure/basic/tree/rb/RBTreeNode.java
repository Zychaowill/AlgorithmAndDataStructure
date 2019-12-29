package com.buildupchao.datastructure.basic.tree.rb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author buildupchao
 * @date 2017/1/3
 */
public class RBTreeNode {
    RBTreeNode parent = nullNode;
    RBTreeNode left = nullNode;
    RBTreeNode right = nullNode;
    int value;
    RBColor color;

    public RBTreeNode() {
    }

    public RBTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + value + " " + color + ")";
    }

    public static RBTreeNode nullNode = new RBTreeNode() {
        {
            color = RBColor.BLACK;
        }

        @Override
        public String toString() {
            return "(null " + color + ")";
        }
    };

    public static RBTreeNode leftRotate(RBTreeNode root, RBTreeNode node) {
        if (node.right == RBTreeNode.nullNode)
            return root;

        RBTreeNode right = node.right;
        node.right = right.left;
        if (node.right != RBTreeNode.nullNode)
            node.right.parent = node;
        if (node.parent != RBTreeNode.nullNode) {
            right.parent = node.parent;
            if (node.parent.left == node)
                node.parent.left = right;
            else
                node.parent.right = right;
        } else {
            root = right;
            root.parent = RBTreeNode.nullNode;
        }
        right.left = node;
        node.parent = right;
        return root;
    }

    public static RBTreeNode rightRotate(RBTreeNode root, RBTreeNode node) {
        if (node.left == RBTreeNode.nullNode)
            return root;

        RBTreeNode left = node.left;
        node.left = left.right;
        if (node.left != RBTreeNode.nullNode)
            node.left.parent = node;
        if (node.parent != RBTreeNode.nullNode) {
            left.parent = node.parent;
            if (node.parent.left == node)
                node.parent.left = left;
            else
                node.parent.right = left;
        } else {
            root = left;
            root.parent = RBTreeNode.nullNode;
        }
        left.right = node;
        node.parent = left;
        return root;
    }

    public static RBTreeNode rbInsert(RBTreeNode root, RBTreeNode insertNode) {
        RBTreeNode position = root;
        RBTreeNode parent = RBTreeNode.nullNode;

        while (position != RBTreeNode.nullNode) {
            parent = position;
            if (insertNode.value < position.value)
                position = position.left;
            else if (insertNode.value > position.value)
                position = position.right;
        }

        insertNode.parent = parent;
        if (parent == RBTreeNode.nullNode)
            root = insertNode;
        else if (insertNode.value < parent.value)
            parent.left = insertNode;
        else if (insertNode.value > parent.value)
            parent.right = insertNode;
        insertNode.color = RBColor.RED;
        return rbInsertFixUp(root, insertNode);
    }

    private static RBTreeNode rbInsertFixUp(RBTreeNode root, RBTreeNode node) {
        RBTreeNode parent = node.parent;
        RBTreeNode grandParent;
        RBTreeNode parentBrother;

        while (parent != RBTreeNode.nullNode && parent.color == RBColor.RED) {
            grandParent = parent.parent;
            if (grandParent.left == parent) {
                parentBrother = grandParent.right;
                if (parentBrother != RBTreeNode.nullNode && parentBrother.color == RBColor.RED) {
                    grandParent.color = RBColor.RED;
                    parent.color = RBColor.BLACK;
                    parentBrother.color = RBColor.BLACK;
                    node = grandParent;
                } else {
                    if (parent.right == node) {
                        root = leftRotate(root, parent);
                        RBTreeNode temp = node;
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
                if (parentBrother != RBTreeNode.nullNode && parentBrother.color == RBColor.RED) {
                    grandParent.color = RBColor.RED;
                    parent.color = RBColor.BLACK;
                    parentBrother.color = RBColor.BLACK;
                    node = grandParent;
                } else {
                    if (parent.left == node) {
                        root = rightRotate(root, parent);
                        RBTreeNode temp = node;
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

    public static RBTreeNode rbDelete(RBTreeNode root, RBTreeNode deleteNode) {
        RBTreeNode replaceNode, fixNode = RBTreeNode.nullNode;
        RBTreeNode fixNodeParent = deleteNode.parent;
        RBColor deleteColor = deleteNode.color;
        if (deleteNode.left == RBTreeNode.nullNode && deleteNode.right == RBTreeNode.nullNode)
            replaceNode = RBTreeNode.nullNode;
        else if (deleteNode.right == RBTreeNode.nullNode) {
            replaceNode = deleteNode.left;
            fixNode = replaceNode;
        } else if (deleteNode.left == RBTreeNode.nullNode) {
            replaceNode = deleteNode.right;
            fixNode = replaceNode;
        } else {
            replaceNode = deleteNode.right;
            while (replaceNode.left != RBTreeNode.nullNode) {
                replaceNode = replaceNode.left;
            }
            fixNode = replaceNode.right;
            if (replaceNode.parent == deleteNode) {
                if (fixNode != RBTreeNode.nullNode) {
                    fixNode.parent = replaceNode;
                }
                fixNodeParent = replaceNode;
            } else {
                replaceNode.parent.left = fixNode;
                if (fixNode != RBTreeNode.nullNode) {
                    fixNode.parent = replaceNode.parent;
                }
                fixNodeParent = replaceNode.parent;
                replaceNode.right = deleteNode.right;
            }

            deleteColor = replaceNode.color;
            replaceNode.color = deleteNode.color;
            replaceNode.left = deleteNode.left;
        }
        if (replaceNode != RBTreeNode.nullNode) {
            replaceNode.parent = deleteNode.parent;
        }
        if (deleteNode.parent == RBTreeNode.nullNode) {
            root = replaceNode;
        } else {
            if (deleteNode.parent.left == deleteNode) {
                deleteNode.parent.left = replaceNode;
            } else {
                deleteNode.parent.right = replaceNode;
            }
        }
        if (deleteColor == RBColor.BLACK) {
            root = rbDeleteFixup(root, fixNode, fixNodeParent);
        }
        return root;
    }

    public static RBTreeNode rbDeleteFixup(RBTreeNode root, RBTreeNode fixNode, RBTreeNode parent) {
        RBTreeNode brother;
        while (root != fixNode && fixNode.color == RBColor.BLACK) {
            parent = fixNode.parent == null ? parent : fixNode.parent;
            if (fixNode == parent.left) {
                brother = parent.right;
                if (brother.color == RBColor.RED) {
                    RBColor temp = brother.color;
                    brother.color = parent.color;
                    parent.color = temp;
                    root = leftRotate(root, parent);
                } else if (brother == RBTreeNode.nullNode) {
                    fixNode = parent;
                } else if (brother.left.color == RBColor.BLACK &&
                        brother.right.color == RBColor.BLACK) {
                    brother.color = RBColor.RED;
                    fixNode = parent;
                } else {
                    if (brother.left.color == RBColor.RED && brother.right.color == RBColor.BLACK) {
                        brother.color = RBColor.RED;
                        brother.left.color = RBColor.BLACK;
                        root = rightRotate(root, brother);
                        brother = brother.parent;
                    }
                    brother.color = parent.color;
                    parent.color = RBColor.BLACK;
                    brother.right.color = RBColor.BLACK;
                    root = leftRotate(root, parent);
                    break;
                }
            } else {
                brother = parent.left;
                if (brother.color == RBColor.RED) {
                    RBColor temp = brother.color;
                    brother.color = parent.color;
                    parent.color = temp;
                    root = rightRotate(root, parent);
                } else if (brother == RBTreeNode.nullNode) {
                    fixNode = parent;
                } else if (brother.left.color == RBColor.BLACK && brother.right.color == RBColor.BLACK) {
                    brother.color = RBColor.RED;
                    fixNode = parent;
                } else {
                    if (brother.right.color == RBColor.RED && brother.left.color == RBColor.BLACK) {
                        brother.color = RBColor.RED;
                        brother.right.color = RBColor.BLACK;
                        root = leftRotate(root, brother);
                        brother = brother.parent;
                    }
                    brother.color = parent.color;
                    parent.color = RBColor.BLACK;
                    brother.left.color = RBColor.BLACK;
                    root = rightRotate(root, parent);
                    break;
                }
            }
        }
        fixNode.color = RBColor.BLACK;
        return root;
    }

    public static void main(String[] args) {
        int num[] = new int[]{5, 4, 1, 6, 3, 2};
        List<RBTreeNode> list = new ArrayList<>();
        RBTreeNode root = RBTreeNode.nullNode;
        for (int i = 0; i < num.length; i++) {
            list.add(new RBTreeNode(num[i]));
            root = rbInsert(root, list.get(i));
            printRBTree(root);
            System.out.println();
        }
        for (int i = 0; i < num.length; i++) {
            root = rbDelete(root, list.get(0));
            list.remove(0);
            printRBTree(root);
            System.out.println();
        }
    }

    public static void printRBTree(RBTreeNode root) {
        if (root == RBTreeNode.nullNode) {
            System.out.println("这是一颗空树");
            return;
        }
        Queue<RBTreeNode> q = new LinkedList<>();
        boolean allNull = false;
        q.add(root);
        while (!allNull) {
            allNull = true;
            Queue<RBTreeNode> rowQ = new LinkedList<>();
            RBTreeNode node;
            while (!q.isEmpty()) {
                node = q.poll();
                System.out.print(node);
                if (node != RBTreeNode.nullNode) {
                    if (node.left != RBTreeNode.nullNode) {
                        rowQ.add(node.left);
                        allNull = false;
                    } else {
                        rowQ.add(RBTreeNode.nullNode);
                    }
                    if (node.right != RBTreeNode.nullNode) {
                        rowQ.add(node.right);
                        allNull = false;
                    } else {
                        rowQ.add(RBTreeNode.nullNode);
                    }
                } else {
                    rowQ.add(RBTreeNode.nullNode);
                    rowQ.add(RBTreeNode.nullNode);
                }
            }
            q = rowQ;
            System.out.println();
        }
    }
}
