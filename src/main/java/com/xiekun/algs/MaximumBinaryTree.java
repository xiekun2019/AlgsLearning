//package com.xiekun.algs;
//
//public class MaximumBinaryTree {
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return construct(nums, 0, nums.length-1);
//    }
//
//    public TreeNode construct(int[] nums, int start, int end){
//        if(end < start) return null;
//        // 先找到最大元素的索引
//        int index = start;
//        for(int i = start; i <= end; i++){
//            if(nums[index] < nums[i]){
//                index = i;
//            }
//        }
//
//        TreeNode root = new TreeNode(nums[index]);
//        root.left = construct(nums, start, index-1);
//        root.right = construct(nums, index+1, end);
//
//        return root;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {3,2,1,6,0,5};
//        TreeNode tree = new MaximumBinaryTree().constructMaximumBinaryTree(nums);
//        TreeNode.traverse(tree);
//    }
//}
//
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//
//    public static void traverse(TreeNode root){
//        if (root == null) return;
//        System.out.println(root.val);
//        traverse(root.left);
//        traverse(root.right);
//    }
//}
