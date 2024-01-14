package Tree.Tree28;


import Tree.BinaryTree.BinayTree;
import Tree.BinaryTree.TreeNode;

public class test {
    public static void main(String[] args) {
        BinayTree tree = new BinayTree();
        int[] array = { 1, 2, 2, 6, 4, 4, 6};
        TreeNode root = tree.CreatTree(array).get(0);
        BinayTree.preOrderTraverse(root);


        Solution su = new Solution();
        su.isSymmetrical(root);
    }
}
