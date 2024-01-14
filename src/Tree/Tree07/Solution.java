package Tree.Tree07;
import Utils.BinaryTree;
import Utils.BinaryTreeNode;
import Utils.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if(pre.length == 0){
            return null;
        }
        int rootValue = pre[0];
        TreeNode Root  = new BinaryTree().CreatBinary(rootValue);

        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if(in[i] == rootValue){
                index = i;
                break;
            }
        }
        Root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,index + 1),Arrays.copyOfRange(in,0,index));
        Root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index +1 ,pre.length),Arrays.copyOfRange(in,index+1,in.length));
        return Root;
    }
}
