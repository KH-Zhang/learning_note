package Tree.Tree55;

import Utils.BinaryTree;
import Utils.BinaryTreeNode;
import Utils.TreeNode;

public class test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode node1 = tree.CreatBinary(1);
        TreeNode node2 = tree.CreatBinary(2);
        TreeNode node3 = tree.CreatBinary(3);
        TreeNode node4 = tree.CreatBinary(4);
        TreeNode node5 = tree.CreatBinary(5);
       TreeNode node6 = tree.CreatBinary(6);
        TreeNode node7 = tree.CreatBinary(7);


        tree.ConnectTreeNode(node1,node2,node3);
        tree.ConnectTreeNode(node2,node4,node5);
        tree.ConnectTreeNode(node5,node7,null);
        tree.ConnectTreeNode(node3,null,node6);

        tree.InorderTravel(node1);
       /* Solution su = new Solution();
        su.TreeDepth(node1);*/

    }

}
