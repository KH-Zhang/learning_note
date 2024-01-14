package Tree.BinaryTree;

public class test {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
        //获取根节点
        BinayTree Tree = new BinayTree();
        TreeNode root = Tree.CreatTree(array).get(0);

        System.out.println("先序遍历：");
        Tree.preOrderTraverse(root);
        System.out.println("后序遍历");
        Tree.postOrderTraverse(root);
        System.out.println("中序遍历");
        Tree.inOrderTraverse(root);

    }
}
