package others;

import java.util.Arrays;

/**
 * 1、如果0的个数大于或者等于间隔数，则为顺子
 * 2、如果出现对子，则不是顺子
 */
public class _61 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        int zeroNum = 0;
        int Interval = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == 0){
                zeroNum++;
                continue;
            }
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            Interval += numbers[i+1] - numbers[i] - 1;
        }
        if(zeroNum >= Interval){
            return true;
        }
        return false;
    }
}
