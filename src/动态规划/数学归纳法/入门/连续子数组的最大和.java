package 动态规划.数学归纳法.入门;

public class 连续子数组的最大和 {

	public int FindGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        int[] dp = new int[length];
        dp[0] = array[0];
        int max = dp[0];
        for(int i=1;i<length;i++){
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

	public static void main(String[] args){
		连续子数组的最大和 main = new 连续子数组的最大和();

		System.out.println(main.FindGreatestSumOfSubArray(new int[] {1,-2,3,10,-4,7,2,-5})); //18
		System.out.println(main.FindGreatestSumOfSubArray(new int[] {2}));
		System.out.println(main.FindGreatestSumOfSubArray(new int[] {-5}));
	}

}