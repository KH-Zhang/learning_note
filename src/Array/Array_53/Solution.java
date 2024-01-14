package Array.Array_53;
/*
    备注：需要重点学习
 */

import java.util.HashMap;
import java.util.Set;

/*
   时间复杂度过高
 */
/*public class Solution {
    public int GetNumberOfK(int [] array , int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                Integer value = map.get(array[i]);
                value++;
                map.put(array[i],value);
            }else{
                map.put(array[i],1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer i :
                set) {
            Integer value = map.get(i);
            if(i == k){
                return value;
            }
        }
        return 0;

    }
}*/

/*
    二分法查找，速度最快
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k){
        int first = getFirst(array,k);
        int last = getLast(array,k);
        if(first == last && first == -1){
            return 0;
        }
        return (last-first+1);

    }

    private int getLast(int[] array, int k) {
        int first =0;
        int last = array.length-1;

        while(first <= last){
            int mid = (first + last)/2;
            if(array[mid] < k){
                first = mid+1;
            }else if(array[mid] > k){
                last = mid -1;
            }else{
                if(mid<array.length-1 && array[mid+1] == k){
                    first = mid+1;
                }else{
                    return mid;
                }

            }
        }
        return -1;
    }

    private int getFirst(int[] array, int k) {
        int first = 0;
        int last = array.length-1;


        while(first <= last){
            int mid = (first + last)/2;
            if(array[mid] < k){
                first = mid+1;
            }
            else if(array[mid] > k){
                last = mid -1;
            }else{
                if(mid>0 && array[mid - 1] == k){
                    last = mid -1;
                }else{
                    return mid;
                }
            }

        }
        return -1;
    }
}