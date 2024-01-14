package Array.Array_03;

public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication){
//        length = numbers.length;
        for (int i = 0; i < length; i++) {
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    //System.out.println("true");
                    return true;
                }
                //交换该下标对应的数字和该数字作为下标对应的数字
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        //System.out.println("false");
        return false;
    }
}
