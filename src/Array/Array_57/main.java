package Array.Array_57;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        int[] array = {1,2,4,7,9,11,15};
        int sum = 13;

        Solution su = new Solution();
        ArrayList<Integer> result = su.FindNumber(array, sum);
        System.out.println(result);
    }
}
