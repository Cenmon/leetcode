package 双指针.对撞指针.第K小.二分搜值;

import java.util.Arrays;

public class 找出第K小的数对距离719H {

    /**
     * 求第K小，可用二分法或快排，二分法确定所有数值的最大和最小值后，计算小于等于中值的数值对个数，再进一步二分
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length,low=0,high=nums[n-1]-nums[0];
        while (low <= high){
            int mid = high - (high - low) / 2;

            // 求nums中小于等于mid的数组对
            int count = 0;
            int left=0,right=1;
            while(right < n){
                while(nums[right] - nums[left] > mid){
                    left++;
                }// 小于等于时跳出
                count += right - left;
                right++;
            }

            if(count >= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        找出第K小的数对距离719H main = new 找出第K小的数对距离719H();

        /**
         * 给定数组以及数字k，求差的绝对值第k小的的数值对，返回数值对的差
         */
        System.out.println(main.smallestDistancePair(new int[]{1,3,1},1)); // 0 数值对有[1,3],[1,1],[3,1]，第一小的则是[1,1],差值为0
        System.out.println(main.smallestDistancePair(new int[]{1,1,1},2)); // 0
        System.out.println(main.smallestDistancePair(new int[]{1,6,1},3)); // 5
    }
}
