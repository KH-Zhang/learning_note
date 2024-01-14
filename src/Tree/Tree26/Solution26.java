package Tree.Tree26;

import Tree.BinaryTree.TreeNode;

public class Solution26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2){

        boolean result = false;
        if(Equal(root1.data, root2.data)){
           result=HasSubtree2(root1,root2);
        }
        if(!result){
            HasSubtree(root1.left,root2);
        }
        if(!result){
            HasSubtree(root1.right,root2);
        }
        System.out.println(result);
        return result;
    }


    public boolean HasSubtree2(TreeNode root1, TreeNode root2){
        if(root2 == null){
            System.out.println("true");
            return true;
        }

        if(root1 == null){
            System.out.println("false");
            return false;
        }

        if(!Equal(root1.data,root2.data)){
            System.out.println("false");
            return false;
        }

        return HasSubtree2(root1.left,root2.left) && HasSubtree2(root1.right,root2.right);
    }



    private boolean Equal(double num1 ,double num2) {
        if((num1 - num2 < 0.0001) && (num2 - num1 < 0.0001)) {
            return true;
        }else{
            return false;
        }

    }
}
