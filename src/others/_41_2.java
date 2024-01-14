package others;

import java.util.LinkedList;
import java.util.Queue;

public class _41_2 {
    private int[] count  = new int[128];
    private Queue<Character> queue = new LinkedList<>();
    public void Insert(char ch) {
        count[ch] ++;
        queue.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty() && count[queue.peek()] > 1){
            queue.poll();
        }
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
