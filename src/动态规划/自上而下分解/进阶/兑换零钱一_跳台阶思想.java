package 动态规划.自上而下分解.进阶;

import Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-03-08 2022-03-08
 */
public class 兑换零钱一_跳台阶思想 {

    public int minMoney (int[] arr, int aim) {
        // write code here
        // dp[i] 兑换i元需要的最少钱数，类似于爬楼梯
        int[] dp = new int[aim+1];
        int len = arr.length;
        Arrays.fill(dp,aim+1);
        dp[0] = 0;
        for(int i=1;i < aim+1;i++){
            for(int j=0;j<len;j++){
                if( i - arr[j] >= 0)
                    dp[i] = Math.min(dp[i],dp[i-arr[j]] + 1);
            }
        }
        return dp[aim] > aim ? -1 : dp[aim];//其他位置也一样
    }
    // 法二：贪心
    public static void main(String[] args) {
        兑换零钱一_跳台阶思想 main = new 兑换零钱一_跳台阶思想();

        int[] ints = {5,2,3}; //4
//        ArrayUtils arrayUtils = new ArrayUtils();
        ArrayUtils.print(ints);
        int res = main.minMoney(ints, 20);
        System.out.println("res = " + res);

    }
}
