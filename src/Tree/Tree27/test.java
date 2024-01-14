package Tree.Tree27;

import Tree.BinaryTree.BinayTree;
import Tree.BinaryTree.TreeNode;
import Tree.Tree28.Solution;

public class test {
    public static void main(String[] args) {
        BinayTree tree = new BinayTree();
        int[] array = { 1, 2, 2, 6, 4, 4, 6};
        TreeNode root = tree.CreatTree(array).get(0);
        BinayTree.preOrderTraverse(root);


        Tree.Tree27.Solution su = new Tree.Tree27.Solution();
        su.Mirror(root);

    }
}
