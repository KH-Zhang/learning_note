package others;

//
public class _43 {
    public  int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0){
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getCount(i);
        }
        return sum;
    }

    private  int getCount(int n) {
        int count = 0;
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                count++;
            }
        }
        return count;
    }
}
