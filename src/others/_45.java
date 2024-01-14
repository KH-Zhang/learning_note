package others;

import java.util.Arrays;
import java.util.Comparator;

public class _45 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0 ){
            return "";
        }

        int length = numbers.length;
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            str[i] = numbers[i] + "";
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o1+o2).compareTo(o2+o1));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
