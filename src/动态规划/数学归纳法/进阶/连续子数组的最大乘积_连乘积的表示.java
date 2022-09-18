package 动态规划.数学归纳法.进阶;

/**
 * @author Cenmo
 * @Date 2022-03-18 2022-03-18
 */
public class 连续子数组的最大乘积_连乘积的表示 {

    /**
     * 还有错误，无法过单个最大值时，负值改变正负时
     * @param nums
     * @return
     */
    public int maxProduct (int[] nums) {
        // write code here
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        int max = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for(int i=1;i<n;i++){
            /**存在负负等正的时候
             * 原状态方程：dp[i] = Math.max(dp[i-1]*nums[i],nums[i]);
             * 但当nums[i]<0时，max([1,n],[2,n],...[n,n])不能直接提出成max([1,n-1],[2,n-2],..[n-1,n-1])*[n]
              */
            dpMax[i] = Math.max(Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            dpMin[i] = Math.min(Math.min(dpMin[i-1]*nums[i],dpMax[i-1]*nums[i]),nums[i]);

            max = Math.max(max,dpMax[i]);
            System.out.print(dpMax[i]+" ");
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        连续子数组的最大乘积_连乘积的表示 main = new 连续子数组的最大乘积_连乘积的表示();

        System.out.println(main.maxProduct(new int[] {3,2,-1,14})); // 连续数组，故为2*3=6
        System.out.println(main.maxProduct(new int[] {-3,0,-2})); // 0
        System.out.println(main.maxProduct(new int[] {-3,2,-2})); // 12
        System.out.println(main.maxProduct(new int[] {-1,-2,-7,-6})); // 84
    }
}
