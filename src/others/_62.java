package others;

import java.util.ArrayList;

public class _62 {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0 || m == 0){
            return -1;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int index = -1;
        while (arr.size() > 1){
            index = (index + m) % arr.size();
            arr.remove(index);
            index--;
        }
        return arr.get(0);
    }
}
