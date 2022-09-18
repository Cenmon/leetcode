package 动态规划.二维;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-07 2022-03-07
 */
public class 矩阵的最小路径和 {

    public int minPathSum (int[][] matrix) {
        /**起点到终点的最短路径
         * 样例：
         * [[1,3,5,9],
         *  [8,1,3,4],
         *  [5,0,6,1],
         *  [8,8,4,0]]
         *  返回值:12
         */
        // write code here
        int m = matrix.length,n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(i == 1 || j == 1){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + matrix[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + matrix[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public int minPathSum2 (int[][] matrix) { // 滚动数组
        /**起点到终点的最短路径
         * 样例：
         * [[1,3,5,9],
         *  [8,1,3,4],
         *  [5,0,6,1],
         *  [8,8,4,0]]
         *  返回值:12
         */
        // write code here
        int m = matrix.length,n = matrix[0].length;
        int[][] dp = new int[2][n+1];
        dp[0][0]=0;dp[1][0]=0;
        int lastI=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i == 1 || j == 1){
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j],dp[i%2][j-1]) + matrix[i-1][j-1];
                }
                else{
                    dp[i%2][j] = Math.min(dp[(i-1)%2][j],dp[i%2][j-1]) + matrix[i-1][j-1];
                }
            }
            lastI = i%2;
        }

        return dp[lastI][n];
    }

    public static void main(String[] args) {
        矩阵的最小路径和 main = new 矩阵的最小路径和();
//        int[][] mat = new int[][] {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};//12
        int[][] mat = new int[][] {{1,2,3},{1,2,3}};//7
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(mat);
        int res = main.minPathSum2(mat);
        System.out.println("res = " + res);
    }
}
