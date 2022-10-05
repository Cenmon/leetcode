package 双指针.窗口指针.滑动窗口.动态窗口.固定左端点.区间和;

/**
 * @Author Cenmo
 * @Date 2022-08-28 11:11
 * @Description 滑动窗口：动态窗口
 */
public class 长度最小的子数组209M {

    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,n=nums.length;
        int sum = 0,ans=Integer.MAX_VALUE;
        while(left<n){
            while(right<n && sum < target){
                sum += nums[right++];
            }
            if(sum < target) break;
            ans = Math.min(ans,right-left);
            sum -= nums[left++];
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }


    public static void main(String[] args) {
        长度最小的子数组209M main = new 长度最小的子数组209M();

        /**
         * 给定一个含有 n 个正整数的数组和一个正整数 target 。
         * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
         * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
         */
        System.out.println(main.minSubArrayLen(7,new int[]{2,3,1,2,4,3})); // 2 [4,3]
        System.out.println(main.minSubArrayLen(4,new int[]{1,4,4})); // 1
        System.out.println(main.minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(main.minSubArrayLen(15,new int[]{1,2,3,4,5})); // 5
    }
}
