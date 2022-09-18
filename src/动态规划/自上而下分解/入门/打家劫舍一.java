package 动态规划.自上而下分解.入门;

/**
 * @author Cenmo
 * @Date 2022-03-25 2022-03-25
 */
public class 打家劫舍一 {

    // 相邻不能偷，要求和最大
    public int rob (int[] nums) {
        // write code here
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        打家劫舍一 main = new 打家劫舍一();

        System.out.println(main.rob(new int[]{1,2,3,4})); // 2+4=6
        System.out.println(main.rob(new int[]{1,3,6}));  // 1+6=7
        System.out.println(main.rob(new int[]{2,10,5})); // 10
    }
}
