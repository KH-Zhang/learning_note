package SearchAndSort.Search_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 需要重新写代码
 */

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input== null || k<=0 || input.length < k){
            return result;
        }
        Arrays.sort(input);
        /*Integer[] arr2 = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            arr2[i] = input[i];
        }

        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }*/
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
}
