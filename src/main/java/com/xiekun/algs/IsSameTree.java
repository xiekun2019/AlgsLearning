package com.xiekun.algs;

import com.xiekun.bean.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p) == traverse(q);
    }

    String traverse(TreeNode root){
        if(root == null){
            return "#";
        }
        String leftStr = traverse(root.left);
        String rightStr = traverse(root.right);
        System.out.println();
        return leftStr + "," + rightStr + "," + root.val;
    }

}
