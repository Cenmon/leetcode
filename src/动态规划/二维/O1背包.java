package 动态规划.二维;

/**
 * @author Cenmo
 * @Date 2022-03-26 2022-03-26
 */
public class O1背包 {

    private int max=0;
    public int maxValue(int[] weights,int[] values,int n,int capacity){
        return max;
    }

    // 递归法
    public void maxValue_recur(int[] weights,int[] values,int maxValue,int n,int index,int remain){
        if(index <= n-1){
            if(remain-weights[index] >= 0){
                maxValue_recur(weights,values,maxValue+values[index],n,index+1,remain-weights[index]); // 要当前这个
            }
            maxValue_recur(weights,values,maxValue,n,index+1,remain); // 不要当前这个
        }else{
            max = maxValue;
        }
    }

    // 二维数组动态规划
    public int maxValue_dpMatrix(int[] weights,int[] values,int n,int capacity){
        int[][] dp = new int[n+1][capacity+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                if(j-weights[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i-1]);
                }
            }
        }
        return dp[n][capacity];
    }

    // 一维数组动态规划
    public int maxValue_dpArray(int[] weights,int[] values,int n,int capacity){
        int[] dp = new int[capacity+1];
        for(int i=1;i<=n;i++){
            for(int j=capacity;j>=weights[i-1];j--){ // 从后往前遍历
                // 注意到二维中只用到前一行数据，故用一维数组记录前一行数据
                // j位置需要用到上一行的j和j-x的位置，即j之前的位置，故从后往前遍历即可
                dp[i] = Math.max(dp[j],dp[j-weights[i-1]]+values[i-1]);
            }
        }
        return dp[capacity];
    }

    /**
     *
     */
    public static void main(String[] args) {
        O1背包 main = new O1背包();
    }
}
