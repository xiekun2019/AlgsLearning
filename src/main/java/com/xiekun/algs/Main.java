package com.xiekun.algs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void traverse(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static int getNum(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftNum = getNum(root.left);
        int rightNum = getNum(root.right);
        return leftNum + rightNum + 1;
    }

}

public class Main {

    ArrayList<Integer> bestPath = new ArrayList<Integer>();
    // 获取最佳路径
    public ArrayList<Integer> getBestPath(TreeNode root, int path){
        if(root == null) {
            return null;
        }

        if(path - root.val == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            return list;
        }

        ArrayList<Integer> bestLeft = getBestPath(root.left, path-root.val);
        ArrayList<Integer> bestRight = getBestPath(root.right, path-root.val);

        if (bestLeft == null && bestRight == null){
            return null;
        }

        if (bestLeft == null) {
            bestPath.addAll(bestRight);
            return bestPath;
        }

        if(bestRight == null) {
            bestPath.addAll(bestLeft);
            return bestPath;
        }

        if(bestLeft.size() <= bestRight.size()){
            bestPath.addAll(bestLeft);
        } else {
            bestPath.addAll(bestRight);
        }
        return bestPath;
    }

    // 通过层次遍历构造二叉树
    public TreeNode buildTree(String [] treeArr){
        TreeNode root = null;
        if(treeArr[0] != null){
            root = new TreeNode(Integer.parseInt(treeArr[0]));
        }
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            // 左子树
            if(i < treeArr.length && !treeArr[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(treeArr[i]));
                queue.offer(node.left);
            } else {
                node.left = null;
            }

            i++;

            if(i < treeArr.length && !treeArr[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(treeArr[i]));
                queue.offer(node.right);
            } else {
                node.right = null;
            }

            i++;
        }
            return root;
    }

    public static void main(String[] args) {
        Main best = new Main();
//        Scanner sc = new Scanner(System.in);
//
//        String next = sc.next();
//        next = next.substring(1, next.length()-1);

        String next = "3,1,5,2,4,4,1";

        String[] splits = next.split(",");
        TreeNode root = best.buildTree(splits);
        ArrayList<Integer> bestPath1 = best.getBestPath(root, 8);
        System.out.println(bestPath1);
    }



}


