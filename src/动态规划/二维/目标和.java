package 动态规划.二维;

/**
 * @author Cenmo
 * @Date 2022-03-26 2022-03-26
 */
public class 目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums)
            sum+=num;
        return sum<target||(sum-target)%2!=0 ? 0 : findTargetSumWays_dpMatrix( nums,(sum-target)/2);
        // return sum<target||(sum-target)%2!=0 ? 0 : findTargetSumWays_dpArray( nums,(sum-target)/2);
        // return find_recur(nums,0,nums.length,target);
    }

    public int find_recur(int[] nums,int index,int n,int target){
        if(index == n){
            return target==0?1:0;
        }else{
            return find_recur(nums,index+1,n,target-nums[index]) + find_recur(nums,index+1,n,target+nums[index]);
        }
    }

    public int findTargetSumWays_dpMatrix(int[] nums, int target) {
        int n=nums.length;
        int[][] dp = new int[n+1][target+1];

        dp[0][0] = 1; // 0个数，目标值为0的方案个数为1
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){ // target有为0的可能
                dp[i][j] = dp[i-1][j]; // 第i个不选
                if( j-nums[i-1] >= 0 ){
                    dp[i][j] +=  dp[i-1][j-nums[i-1]]; // 第i个选
                }
            }
        }
        return dp[n][target];
    }

    public int findTargetSumWays_dpArray(int[] nums, int target) {
        int n=nums.length;
        int[] dp = new int[target+1];

        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=target;j>=nums[i-1];j--){
                dp[j] = dp[j] + dp[ j-nums[i-1] ];
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
        return dp[target];
    }

    /**
     * 给出一组数组，求添加加号减号使得其和为目标值，求其和为0的方案个数
     */
    public static void main(String[] args) {
        目标和 main = new 目标和();

        System.out.println(main.findTargetSumWays(new int[]{100}, -200)); // 0
        System.out.println(main.findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9}, 0)); // 0
//        System.out.println(main.findTargetSumWays(new int[]{100}, -200)); // 0
    }
}
