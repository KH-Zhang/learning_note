package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/profile/1650964/codeBookDetail?submissionId=17493472
 */
public class _49 {
    /*public int GetUglyNumber_Solution(int index) {
        if(index < 0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0,i3 = 0,i5 = 0;
        while (list.size() < index){
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;

            int min = Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min == m2){
                i2++;
            }
            if(min == m3){
                i3++;
            }
            if(min == m5){
                i5++;
            }
        }
        return list.get(list.size()-1);
    }*/

    public int GetUglyNumber_Solution(int index){
        if(index <= 0){
            return 0;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);

        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue3 = new LinkedList<>();
        Queue<Integer> queue5 = new LinkedList<>();

        queue2.add(2);
        queue3.add(3);
        queue5.add(5);

        while (result.size() < index){
            int number = Math.min(queue2.peek(),Math.min(queue3.peek(),queue5.peek()));
            result.add(number);
            if(number == queue2.peek()){
                queue2.poll();
            }
            if(number == queue3.peek()){
                queue3.poll();
            }
            if(number == queue5.peek()){
                queue5.poll();
            }

            queue2.add(number * 2);
            queue3.add(number * 3);
            queue5.add(number * 5);

        }

        return result.get(result.size() -1);
    }


}
