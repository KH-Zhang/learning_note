package Array.Array_39;

import java.util.HashMap;
import java.util.Set;

/*
解法1：own 时间复杂度O(n)
 */
/*
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                Integer value = map.get(array[i]);
                value++;
                map.put(array[i],value);
            }
            else{
                map.put(array[i],1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer i:
             set) {
            if(map.get(i) > array.length/2){
                System.out.println(i);
                return i;
            }
        }
        System.out.println(0);
        return 0;
    }
}
*/


/*
解法2：other 时间复杂度O(n)
 */
/*public class Solution {
    public int MoreThanHalfNum_Solution(int [] array){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                Integer value = map.get(array[i]);
                value++;
                map.put(array[i],value);
            }
            else{
                map.put(array[i],1);
            }
            if(map.get(array[i]) > array.length/2){
                System.out.println(array[i]);
                return array[i];
            }
        }
        System.out.println(0);
        return 0;
    }
}*/


/*
解法三 O(n2)

 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array){
        if(array == null){
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j]){
                    count++;
                }
            }
            if(count > array.length/2){
                System.out.println(array[i]);
                return array[i];
            }
        }
        System.out.println(0);
        return 0;
    }
}