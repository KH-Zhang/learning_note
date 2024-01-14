package Tree.Tree07;

public class test {
    public static void main(String[] args) {
        Solution su = new Solution();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        su.reConstructBinaryTree(pre,in);

    }
}
