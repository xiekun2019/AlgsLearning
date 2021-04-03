package com.xiekun.algs;

import com.xiekun.bean.TreeNode;

public class MyBuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preEnd < preStart || inEnd < inStart) return null;

        int rootVal = preorder[preStart];
        // 找到 root节点 在inorder的位置
        int index = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 创建根节点
        TreeNode root = new TreeNode(rootVal);

        // 左子树前序的数量
        int leftPreNum = index - inStart;

        root.left = build(preorder, preStart+1, preStart+leftPreNum, inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftPreNum+1, preEnd, inorder, index+1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode root = new MyBuildTree().buildTree(preorder, inorder);
        TreeNode.traverse(root);
    }
}
