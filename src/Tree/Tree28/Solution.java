package Tree.Tree28;

import Tree.BinaryTree.TreeNode;


public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return  isSymmetrical(pRoot.left,pRoot.right);
    }
    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null){
            System.out.println("ture");
            return true;
        }

        if(pRoot1 == null || pRoot2 == null){
            System.out.println("false");
            return false;
        }

        if(pRoot1.data != pRoot2.data){
            System.out.println("false");
            return false;
        }

        return isSymmetrical(pRoot1.left,pRoot2.right) && isSymmetrical(pRoot1.right,pRoot2.left);
    }

}


