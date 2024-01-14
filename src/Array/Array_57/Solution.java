package Array.Array_57;
import java.util.ArrayList;
/*
解法1笔记：
1、使用两个指针，外循环使用while
2、夹逼准则推导乘积最小的两个数是最外层的两个
 */
/*public class Solution {
    public ArrayList<Integer> FindNumber(int[] array,int sum){
        int FirstIndex = 0;
        int LastIndex = array.length-1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(FirstIndex < LastIndex){
            if(array[FirstIndex] + array[LastIndex] < sum){
                FirstIndex+=1;
            }else if(array[FirstIndex] + array[LastIndex] > sum){
                LastIndex-=1;
            }else if(array[FirstIndex] + array[LastIndex] == sum){
                arrayList.add(array[FirstIndex]);
                arrayList.add(array[LastIndex]);
                break;
            }
        }
        return arrayList;
    }
}*/


/*
解法2笔记
重点：
result.add(new ArrayList<>(list));
 */
public class Solution{
    public ArrayList<Integer> FindNumber(int[] array, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] + array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    result.add(new ArrayList<>(list));
                }
            }
        }
        if (result.size() == 0) {
            return list;
        } else if (result.size() == 1) {
            return result.get(0);
        } else {
            list.clear();
            list = result.get(0);
            int range = list.get(0) * list.get(1);
            for (int i = 1; i < result.size() -1; i++) {
                int range2 = result.get(i).get(0) * result.get(i).get(1);
                if(range2 <range){
                    list.clear();
                    list = result.get(i);
                    range = range2;
                }
            }
            return list;
        }
    }
}


/*
解法3，最优解
*/

/*
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(sum<3)return list;
        int start = 0;
        int end = array.length-1;
        while(start < end){
            if(array[start]+ array[end] == sum){
                list.add(array[start]);
                list.add(array[end]);
                result.add(new ArrayList<Integer>(list));
                end--;
            }
            else if(array[start]+ array[end] > sum){
                end--;
            }else {
                start ++;
            }
        }
        if(result.size() == 0)return list;
        else if(result.size() == 1){
            return result.get(0);
        }
        else {
            list.clear();
            int length = result.size() - 1;
            list = result.get(0);
            int mul = list.get(0)*list.get(1);
            for(int i=1;i<=length;i++){
                int tmp = result.get(i).get(0)*result.get(i).get(1);
                if(tmp<mul){
                    list.clear();
                    list=result.get(i);
                    mul = tmp;
                }
            }
            return list;
        }

    }
}*/
