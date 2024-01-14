package Tree.Tree26;

import Tree.BinaryTree.BinayTree;
import Tree.BinaryTree.TreeNode;

public class test {
    public static void main(String[] args) {
        BinayTree tree = new BinayTree();
        int[] array = { 8,8,7,9,2,-1,-1,-1,-1,4,7};
        TreeNode root = tree.CreatTree(array).get(0);
        BinayTree.preOrderTraverse(root);


        BinayTree tree2 = new BinayTree();
        int[] array2 = { 8,9,2};
        TreeNode root2 = tree2.CreatTree(array2).get(0);


        Solution26 su = new Solution26();
        su.HasSubtree(root,root2);
    }
}
