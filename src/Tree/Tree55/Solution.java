package Tree.Tree55;


import Utils.BinaryTreeNode;

public class Solution {
    public int TreeDepth(BinaryTreeNode root){

        if(root == null){
            return 0;
        }
        int left  = TreeDepth(root.Left);
        int right = TreeDepth(root.Right);

        return left>right ? (left+1) : (right+1);
    }
}
