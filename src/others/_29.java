package others;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
 */

public class _29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int l = 0;  //左
        int r = matrix[0].length-1; //右
        int t = 0; //上
        int b = matrix.length-1; //下
        ArrayList<Integer> result = new ArrayList<>();

        while (true){
            //从左到右
            for (int i = l; i <= r ; i++) {
                result.add(matrix[t][i]);
            }
            if(++t > b) break;

            //从上到下
            for (int i = t; i <=b ; i++) {
                result.add(matrix[i][r]);
            }
            if(--r < l) break;

            //从右到左
            for (int i = r; i >= l ; i--) {
                result.add(matrix[b][i]);
            }

            if(--b < t) break;

            //从下到上
            for (int i = b; i >= t ; i--) {
                result.add(matrix[i][l]);
            }

            if(++l > r) break;
        }
        return  result;
    }
}
