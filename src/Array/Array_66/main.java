package Array.Array_66;

public class main {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        Solution su = new Solution();
        int[] multiply = su.multiply(arr);
        for (int i = 0; i < multiply.length; i++) {
            System.out.println(multiply[i]);
        }
    }
}
