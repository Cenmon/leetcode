package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

/**
 * @Author Cenmo
 * @Date 2022-08-29 10:42
 * @Description : while型窗口缺点：right有可能在left坐标，需要复位
 */
public class 连乘积小于K的子数组713M {

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int left=0,right=0,n=nums.length,ans=0;
        long multi=1;
        while(left < n){
            if(right < left){
                right = left;
                multi = 1;
            }
            while(right<n && multi*nums[right] < k){
                multi *= nums[right++];
            }
            ans += right - left;
            multi /= nums[left++];
        }
        return ans;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k){
        int i=0,mult=1,ans=0;
        for(int j=0,n=nums.length;j<n;j++){
            mult *= nums[j];
            while (i<=j && mult >= k){
                mult /= nums[i++];
            }
            if(mult < k){ // 该条件可以省略，则leetcode双百
                ans += j-i+1; // 元素本身也可以是个数组
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        连乘积小于K的子数组713M main = new 连乘积小于K的子数组713M();

        /**
         * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
         */
        System.out.println(main.numSubarrayProductLessThanK(new int[]{10,5,2,6},100)); // 8
        System.out.println(main.numSubarrayProductLessThanK(new int[]{1,2,3},0)); // 0
        System.out.println(main.numSubarrayProductLessThanK(new int[]{57,44,92,28,66,60,37,33,52,38,29,76,8,75,22},18)); // 1
    }
}
