package com.xiekun.bean;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
