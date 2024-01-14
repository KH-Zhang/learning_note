package Tree.Tree37;

import Tree.BinaryTree.BinayTree;
import Tree.BinaryTree.TreeNode;

public class test {
    public static void main(String[] args) {
        int[] array = { 1,2,4,-1,-1,-1,3,5,-1,-1,6,-1,-1 };
        //获取根节点
        BinayTree Tree = new BinayTree();
        TreeNode root = Tree.CreatTree(array).get(0);

        Solution su = new Solution();
        String serialize = su.Serialize(root);
        System.out.println(serialize);


    }
}
