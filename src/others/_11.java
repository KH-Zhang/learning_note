package others;

public class _11 {
    public int minNumberInRotateArray(int [] array) {
        if(array == null){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }



}
