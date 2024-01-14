package SearchAndSort.Search_40;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        int[] a = {3,4,6,1,2,5,7};
        Solution su = new Solution();
        ArrayList<Integer> arrayList = su.GetLeastNumbers_Solution(a, 3);
        System.out.println(arrayList);
    }
}
