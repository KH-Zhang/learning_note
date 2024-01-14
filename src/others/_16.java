package others;

public class _16 {
    public double Power(double base, int exponent) {
        double result = 1;
        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }else if(exponent < 0){
            int n = Math.abs(exponent);
            for (int i = 0; i < n; i++) {
                result *= base;
            }
            result = 1 / result;
        } else {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        }
        return result;
    }
}
