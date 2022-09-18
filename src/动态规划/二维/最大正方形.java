package 动态规划.二维;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-18 2022-03-18
 * https://www.bilibili.com/video/BV1st4y117m5?spm_id_from=333.999.0.0
 */
public class 最大正方形 {

    public int MaxSqure(int[][] arr){
        int m = arr.length,n = arr[0].length;
        int[][] dp = new int[m+1][n+1]; // 记录以arr[i][j]为右下角的最大正方形边长
        int ans = 0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(arr[i-1][j-1] == 1){
                    dp[i][j] = Math.min( Math.min(dp[i-1][j],dp[i][j-1]) , dp[i-1][j-1] ) + 1;
                    ans = Math.max(ans,dp[i][j]); // 记录最大边长
                }
            }
        }
        new ArrayUtils().print(dp,"dp");
        return ans * ans; // 返回最大正方形面积
    }

    public static void main(String[] args) {
        最大正方形 main = new 最大正方形();
        int[][] arr = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(arr);
        System.out.println(main.MaxSqure(arr));
    }
}
