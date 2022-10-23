package 二分.连续区间的二分;

/**
 * @Author Cenmo
 * @Date 2022-10-13 20:04
 * @Description
 */
public class 子数组的最大平均值二644H {

    // public double maxAverage(int[] nums, int k) { // 超时
    //     // write your code here
    //     int n = nums.length;
    //     long[] presum = new long[n];
    //     presum[0] = nums[0];
    //     for(int i=1;i<n;i++) presum[i] = presum[i-1]+nums[i];

    //     double ans = -Double.MAX_VALUE;
    //     for(int i=k;i<=n;i++){ // 子数组宽度
    //         ans = Math.max(ans,(double)presum[i-1]/i);
    //         for(int j=0;j<n-i;j++){
    //             ans = Math.max(ans,(double)(presum[j+i]-presum[j])/i);
    //         }
    //     }
    //     return ans;
    // }

    public double maxAverage(int[] nums, int k) { // 二分
        int min=nums[0],max=nums[0];
        for(int num : nums){
            if(num < min) min = num;
            if(num > max) max = num;
        }
        // 求最大平均值，且子数组长度 >= k
        double left=min,right=max; // 最小平均值和最大平均值，当数组值全为最小值时数组平均值最小
        while(right - left > 1e-3){
            double mid = left + (right-left)/2;
            if(existSubsequenceAverageMoreAndEqualMid(nums,mid,k)){ // 存在某个长度大于等于k的数组平均值大于mid
                left = mid; // 存在则观察更大的mid
            }else{ // 不存在
                right = mid;
            }

        }
        return right;
    }

    // 判断nums中是否存在某个长度大于等于k的子数组，数组平均值大于avg
    private boolean existSubsequenceAverageMoreAndEqualMid(int[] nums,double avg,int k){
        int n = nums.length;
        double[] presum = new double[n+1];

        for(int i=1;i<=n;i++){
            presum[i] = presum[i-1] + nums[i-1] - avg; // nums每个数组值减去avg后的前缀和
        }
        // 判断存在某个子数组平均值大于等于指定avg -> 判断存在某个子数组和大于等于0
        // 子数组和sum[i:j] = presum[j] - presum[i-1] > 0 -> presum[j] >= presum[i-1]
        // 即遍历前缀和每个j，若前面存在某个i-1使得presum[j]大于等于presum[i-1],显然presum[i-1]应该最好是最小值
        double preMin = 0.0;
        for(int j=k;j<=n;j++){ // 保证子数组长度大于等于k
            if(presum[j-k] < preMin){ // j-k之前的最小值，保证子数组长度>=k
                preMin = presum[j-k];
            }
            if(presum[j]-preMin >= 0) return true;

        }
        return false;
    }


    public static void main(String[] args) {
        子数组的最大平均值二644H main = new 子数组的最大平均值二644H();

        /**
         * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
         */
        System.out.println(main.maxAverage(new int[]{1,12,-5,-6,50,3},3)); // 15.67
        System.out.println(main.maxAverage(new int[]{5},1)); // 5.00
        System.out.println(main.maxAverage(new int[]{5,-10,4},2)); // -0.33
        System.out.println(main.maxAverage(new int[]{-2147483648,-2147483648,-2147483648,-2147483648},2)); // -2147483648.00
    }
}
