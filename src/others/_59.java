package others;
import java.util.ArrayList;

public class _59 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(num.length == 0 || num.length < size || size == 0){
            return result;
        }
        for (int i = 0; i < num.length - size +1; i++) {
            int max = num[i];
            for (int j = i; j < i+size ; j++) {
                if(num[j] > max){
                    max = num[j];
                }
            }
            result.add(max);
        }
        return result;
    }

}
