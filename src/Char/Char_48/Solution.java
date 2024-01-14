package Char.Char_48;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        while (right < s.length() ){
            char c = s.charAt(right);
            right++;

            //窗口操作
            set.add(c);
            //maxLength = Math.max(maxLength,right-left);
            maxLength = Math.max(maxLength,set.size());


            //判断左窗口是否要收缩
            while (right < s.length() && set.contains(s.charAt(right)) /*&& left < right*/){
                set.remove(s.charAt(left));
                left++;
            }


        }
        return maxLength;

    }

}
