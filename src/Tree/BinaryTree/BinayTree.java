package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.List;

//从0开始编号
//https://www.cnblogs.com/ccxka/p/9600520.html
public class BinayTree {
    public List<TreeNode> CreatTree(int[] array){
        List<TreeNode> nodelist = new LinkedList<>();
        //将每个位置转换为节点
        for (int i = 0; i < array.length; i++) {
            nodelist.add(new TreeNode(array[i]));
        }
        for (int i = 0; i < array.length/2 -1; i++) {
            //左孩子
            nodelist.get(i).left = nodelist.get(i*2+1);
            //右孩子
            nodelist.get(i).right = nodelist.get(i*2+2);
        }


        //如果是奇数，则有右孩子
        if(array.length%2 == 1)
        {
            nodelist.get(array.length/2 -1).left = nodelist.get(array.length-2);
            nodelist.get(array.length/2 -1).right = nodelist.get(array.length-1);

        }else{
            nodelist.get(array.length/2 -1).left = nodelist.get(array.length-1);
        }
        return nodelist;

    }

    public static void preOrderTraverse(TreeNode node){
         if(node == null) return;
         //根
         System.out.print(node.data + " ");
         //左
         preOrderTraverse(node.left);
         //右
         preOrderTraverse(node.right);
     }

    public static void postOrderTraverse(TreeNode node){
        if(node == null) return;

        //左
        postOrderTraverse(node.left);
        //右
        postOrderTraverse(node.right);
        //根
        System.out.print(node.data + " ");
    }

    public static void inOrderTraverse(TreeNode node){
        if(node == null) return;

        //左
        inOrderTraverse(node.left);
        //右
        inOrderTraverse(node.right);
        //根
        System.out.print(node.data + " ");
    }

}
