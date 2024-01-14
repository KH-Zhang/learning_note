package Array.Array_45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//需要重点学习

public class Solution {
    public static String PrintMinNumber(int [] numbers){
        int length = numbers.length;
        String[] str = new String[length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String C1 = o1+o2;
                String C2 = o2+o1;
                return C1.compareTo(C2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }

        return sb.toString();

    }

    //第二种实现方法
    public class Solution2 {
        public String PrintMinNumber(int [] numbers) {
            int n = numbers.length;
            String s= "";
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i =0;i<n;i++){
                list.add(numbers[i]);
            }
            Collections.sort(list,new Comparator<Integer>(){
                @Override
                public int compare(Integer str1, Integer str2) {
                    String s1=str1+""+str2;//Integer类型转换为字符串的过程
                    String s2=str2+""+str1;
                    return s1.compareTo(s2);
                }
            });
            for(int j:list){
                s=s+j;
            }
            return s;
        }

    }



    public static void main(String[] args) {
        int[] number = {1,22,35,34};
        String s = PrintMinNumber(number);
        System.out.println(s);
    }
}
