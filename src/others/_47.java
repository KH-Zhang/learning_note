package others;

/**
 * 参考（二维数组的案例三）：https://zhuanlan.zhihu.com/p/91582909
 */

public class _47 {
    public int getMost(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return 0;
        }

        int n = board[0].length;
        int[] dp = new int[n];
        for (int[] value : board) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i],dp[i-1])+value[i];
            }
        }

        return dp[n-1];
    }
}
