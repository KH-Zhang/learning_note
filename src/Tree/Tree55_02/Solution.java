package Tree.Tree55_02;


import Utils.BinaryTreeNode;

public class Solution {
    /*public boolean IsBalanced_Solution(BinaryTreeNode root){

        if(root == null){
            return true;
        }

        int left = getDepth(root.Left);
        int right = getDepth(root.Right);

        if((left - right) > 1 || (right - left) > 1){
            return false;
        }

        return IsBalanced_Solution(root.Left) && IsBalanced_Solution(root.Right);
    }

    private int getDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }

        int left = getDepth(root.Left);
        int right = getDepth(root.Right);

        return left > right ? (left + 1) : (right + 1);
    }*/

    public boolean IsBalanced_Solution(BinaryTreeNode root){
        if(root == null){
            return true;
        }

        int left = getDepth(root.Left);
        int right = getDepth(root.Right);

        if((left - right) > 1 || (right - left) > 1 ){
            return false;
        }

        return IsBalanced_Solution(root.Left) && IsBalanced_Solution(root.Right);
    }

    private int getDepth(BinaryTreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.Left);
        int right = getDepth(root.Right);

        return left > right ? (left + 1) : (right +1);
    }
}
