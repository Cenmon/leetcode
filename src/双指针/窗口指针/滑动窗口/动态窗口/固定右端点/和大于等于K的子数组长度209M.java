package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

/**
 * @Author Cenmo
 * @Date 2022-08-28 11:11
 * @Description 滑动窗口：动态窗口
 */
public class 和大于等于K的子数组长度209M {

//    public int minSubArrayLen2(int target, int[] nums) {
//        int left=0,right=0,n=nums.length;
//        int sum = 0,ans=Integer.MAX_VALUE;
//        while(left<n){
//            while(right<n && sum < target){
//                sum += nums[right++];
//            }
//            if(sum < target) break;
//            ans = Math.min(ans,right-left);
//            sum -= nums[left++];
//        }
//        return ans==Integer.MAX_VALUE?0:ans;
//    }

    public int minSubArrayLen2(int target, int[] nums) {
        int j=0,sum=0,ans=Integer.MAX_VALUE;
        for(int i=0,n=nums.length;i<n;i++){
            while(j<n && sum < target){
                sum += nums[j++];
            }
            if(sum < target) break; // j=n 且 sum < target
            ans = Math.min(ans,j-i);
//            if(j >= n) break;
            sum -= nums[i];
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public int minSubArrayLen(int target, int[] nums){ // 固定右窗口
        int i=0,sum=0,ans=Integer.MAX_VALUE;
        for(int j=0,n=nums.length;j<n;j++){
            sum += nums[j]; // 入队
            while (sum >= target){
                if(j-i+1 < ans){
                    ans = j-i+1;
                }
                sum -= nums[i++]; // 出队
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }


    public static void main(String[] args) {
        和大于等于K的子数组长度209M main = new 和大于等于K的子数组长度209M();

        /**
         * 给定一个含有 n 个正整数的数组和一个正整数 target 。
         * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
         * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
         */
        System.out.println(main.minSubArrayLen(7,new int[]{2,3,1,2,4,3})); // 2 [4,3]
        System.out.println(main.minSubArrayLen(4,new int[]{1,4,4})); // 1
        System.out.println(main.minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(main.minSubArrayLen(15,new int[]{1,2,3,4,5})); // 5

        System.out.println();
        System.out.println(main.minSubArrayLen2(7,new int[]{2,3,1,2,4,3})); // 2 [4,3]
        System.out.println(main.minSubArrayLen2(4,new int[]{1,4,4})); // 1
        System.out.println(main.minSubArrayLen2(11,new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(main.minSubArrayLen2(15,new int[]{1,2,3,4,5})); // 5
    }
}
