package others;

public class _42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(sum+array[i],array[i]);
            result = Math.max(result,sum);
        }
        return result;
    }
}
