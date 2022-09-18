package 动态规划.二维;

import java.util.Scanner;

/**
 * @author Cenmo
 * @Date 2022-03-28 2022-03-28
 */
public class 矩阵首行到尾行的最大路径和 {

    int[][] direct = new int[][] {{1,-1},{1,0},{1,1}};
    int max = 0;
    public int pathSum2(int[][] array) {
        int m=array.length,n=array[0].length;
        for(int i=0;i<n;i++){
            process(array,m,n,0,i,array[0][i]);
        }
        return max;
    }

    private void process(int[][] array, int m, int n, int x, int y, int sum) {
        if(x == m-1){
            max = Math.max(max,sum);
        }else{
            for(int i=0;i<3;i++){
                int newx = x + direct[i][0];
                int newy = y + direct[i][1];
                if(newx>=0 && newx<m && newy>=0 && newy<n){
                    process(array,m,n,newx,newy,sum+array[newx][newy]);
                }
            }
        }
    }

    public int pathSum3(int[][] array) {
        int m=array.length,n=array[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j+1 <= n){
                    dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]);
                }
                dp[i][j] += array[i-1][j-1];
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            max = Math.max(max,dp[m][i]);
        }
        return max;
    }


    public int pathSum(int[][] array) {
        int m=array.length,n=array[0].length;
        int[][] dp = new int[2][n+1];
        int lastI=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j+1 <= n){
                    dp[i%2][j] = Math.max(Math.max(dp[(i-1)%2][j],dp[(i-1)%2][j-1]),dp[(i-1)%2][j+1]);
                }else{
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j],dp[(i-1)%2][j-1]);
                }
                dp[i%2][j] += array[i-1][j-1];
                lastI = i%2;
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            max = Math.max(max,dp[lastI][i]);
        }
        return max;
    }


    /**
     * m行n列，给出矩阵，从最上边去到最下边，求和最大
     * 3 2
     * 1 2
     * 3 1
     * 1 4
     * 二维化一维时，要求下一行数据不用到上一行
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int array_rows = 0;
        int array_cols = 0;
        array_rows = in.nextInt();
        array_cols = in.nextInt();

        int[][] array = new int[array_rows][array_cols];
        for(int array_i=0; array_i<array_rows; array_i++) {
            for(int array_j=0; array_j<array_cols; array_j++) {
                array[array_i][array_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        res = new 矩阵首行到尾行的最大路径和().pathSum(array);
        System.out.println(String.valueOf(res));

    }
}
