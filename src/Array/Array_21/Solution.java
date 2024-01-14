package Array.Array_21;

public class Solution {
    public static  int[] reOrderArray(int [] array){

        for (int i = 1; i < array.length; i++) {
            if(array[i]%2 == 1){
                int k = i-1;
                int temp = array[i];
                while(k>= 0 && array[k]%2 == 0){
                    array[k+1] = array[k];
                    k--;
                }
                array[k+1] = temp;
            }
        }
        return array;
    }

    /**
     * 偶数方奇数前面
     * @param array
     * @return
     */
    public static  int[] reOrderArray2(int [] array){

        for (int i = 1; i < array.length; i++) {
            if(array[i]%2 == 0){
                int k = i-1;
                int temp = array[i];
                while(k>= 0 && array[k]%2 == 1){
                    array[k+1] = array[k];
                    k--;
                }
                array[k+1] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] ints = reOrderArray2(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
