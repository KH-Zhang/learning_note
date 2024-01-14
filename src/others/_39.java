package others;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        if(array.length == 0){
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            /*if(map.containsKey(array[i])){
                Integer value = map.get(i);
                value++;
                map.put(array[i],value);
            }else {
                map.put(array[i],1);
            }*/
            Integer value = map.getOrDefault(array[i], 0);
            value++;
            map.put(array[i],value);
        }
        Set<Integer> set = map.keySet();
        for (Integer i :
                set) {
            if(map.get(i) > array.length/2){
                return i;
            }
        }
        return 0;
    }
}
