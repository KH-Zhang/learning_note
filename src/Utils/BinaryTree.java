package Utils;

public class BinaryTree {

    /*private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            val = value;
            left = null;
            right = null;
        }

        public TreeNode() {

        }
    }*/

    public TreeNode CreatBinary(int data){
        TreeNode node = new TreeNode();
        node.val = data;
        node.left = null;
        node.right = null;
        return node;
    }

    public void ConnectTreeNode(TreeNode root, TreeNode left, TreeNode right){
        if(root != null){
            root.left = left;
            root.right = right;
        }
    }

    public void PrintTreeNode(TreeNode node){
        if(node != null){
            System.out.println("value of this node is: "+node.val);
            if(node.left != null){
                System.out.println("value of its left child is: "+node.left.val);
            }else{
                System.out.println("its left child is null");
            }
            if(node.right != null){
                System.out.println("value of its right child is: "+node.right.val);
            }else{
                System.out.println("its right child is null");
            }

        }else{
            System.out.println("this node is null");
        }
    }

    public void PrintTree(TreeNode root){
        PrintTreeNode(root);
        if(root != null){
            if(root.left != null){
                PrintTreeNode(root.left);
            }
            if(root.right != null){
                PrintTreeNode(root.right);
            }
        }
    }

    public void PreTravel(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            PreTravel(root.left);
            PreTravel(root.right);
        }
    }

    public void InorderTravel(TreeNode root){
        if(root != null){
            InorderTravel(root.left);
            System.out.println(root.val);
            InorderTravel(root.right);
        }
    }


    public void PostTravel(TreeNode root){
        if(root != null){
            PostTravel(root.left);
            PostTravel(root.right);
            System.out.println(root.val);
        }
    }

}
