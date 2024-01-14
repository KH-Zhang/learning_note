package Char.Char_50;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int FirstNotRepeatingChar(String str) {

        Map<Character,Integer> mp =new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if(mp.containsKey(str.charAt(i))){
                Integer count = mp.get(str.charAt(i));
                mp.put(str.charAt(i),++count);
            }else{
                mp.put(str.charAt(i),1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if(mp.get(str.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}
