package others;

public class _64 {
    int result = 0;
    public  int sumNums(int n){
        if(n > 1){
            sumNums(n -1);
        }
        result += n;
        return result;
    }
}
