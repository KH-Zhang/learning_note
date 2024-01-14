package Tree.Tree32_01;

import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.ArrayList;

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
        tree.ConnectTreeNode(node3,node6,node7);

        Solution su = new Solution();
        ArrayList<ArrayList<Integer>> print = su.Print(node1);
        ArrayList<Integer> arrayList = print.get(0);
        for (Integer i:arrayList
             ) {
            System.out.println(i);
        }

        ArrayList<Integer> arrayList2 = print.get(1);
        for (Integer i:arrayList2
                ) {
            System.out.println(i);
        }
        ArrayList<Integer> arrayList3 = print.get(2);
        for (Integer i:arrayList3
                ) {
            System.out.println(i);
        }
    }
}
