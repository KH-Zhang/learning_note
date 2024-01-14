package Tree.Tree37;

import Tree.BinaryTree.TreeNode;

public class Solution {


    String Serialize(TreeNode root) {
        if(root.data == -1){
            return "# ";
        }
        StringBuilder s = new StringBuilder();
        s.append(root.data);
        s.append(" ");
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));

        return s.toString();
    }
    /*TreeNode Deserialize(String str) {

    }*/
}
