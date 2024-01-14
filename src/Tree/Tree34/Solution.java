package Tree.Tree34;



import Utils.BinaryTree;
import Utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    /*private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        backTrace(root,target,new ArrayList<Integer>());
        return result;
    }


    private static void backTrace(TreeNode root, int target, ArrayList<Integer> temp) {
        if(root == null){
            return;
        }

        temp.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(temp));
        }

        backTrace(root.left,target,temp);
        backTrace(root.right,target,temp);

        target += temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
    }*/


    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            backTrace(pop,target,new ArrayList<Integer>());
            if(pop.left != null){
                stack.push(pop.left);
            }
            if(pop.right != null){
                stack.push(pop.right);
            }
        }
        return result;
    }

    private static void backTrace(TreeNode root, int target, ArrayList<Integer> temp) {
        if(root == null){
            return;
        }
        temp.add(root.val);
        target -= root.val;

        if(target == 0 /*&& root.left == null && root.right == null*/){
            result.add(new ArrayList<>(temp));
        }

        backTrace(root.left,target,temp);
        backTrace(root.right,target,temp);

        target += temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode node1  = tree.CreatBinary(5);
        TreeNode node2  = tree.CreatBinary(4);
        TreeNode node3  = tree.CreatBinary(8);
        TreeNode node4  = tree.CreatBinary(11);
        TreeNode node5  = tree.CreatBinary(13);
        TreeNode node6  = tree.CreatBinary(4);
        TreeNode node7  = tree.CreatBinary(7);
        TreeNode node8  = tree.CreatBinary(2);
        TreeNode node9  = tree.CreatBinary(5);
        TreeNode node10  = tree.CreatBinary(1);


        tree.ConnectTreeNode(node1,node2,node3);
        tree.ConnectTreeNode(node2,node4,null);
        tree.ConnectTreeNode(node4,node7,node8);
        tree.ConnectTreeNode(node3,node5,node6);
        tree.ConnectTreeNode(node6,node9,node10);

        System.out.println(FindPath(node1, 22));

    }

}



