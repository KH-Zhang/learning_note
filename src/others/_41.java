package others;

/**
 * https://sunweiguo.github.io/2019/03/18/剑指offer/【面试题63-数据流中的中位数】/
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class _41 {
    //左边是最大堆（降序）
    private PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2- o1));
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;
    public void Insert(Integer num) {
        if(N % 2 == 0){//因为N是从0开始的
            left.add(num);
            right.add(left.poll());
        }else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if(N % 2 == 0){
            return (left.peek() + right.peek())/2.0;
        }else {
            return (double) right.peek();//因为N是从0开始的
        }
    }


}
