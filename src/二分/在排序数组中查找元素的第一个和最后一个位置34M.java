package 二分;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-10-09 19:52
 * @Description
 */
public class 在排序数组中查找元素的第一个和最后一个位置34M {

    // 最左二分+最右二分
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        // 最左二分
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                right = mid-1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        int start = left<nums.length && nums[left]==target ? left : -1;
        // 最右二分
        left = 0;right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        int end = right>=0 && nums[right]==target ? right : -1;
        return new int[]{start,end};
    }


    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置34M main = new 在排序数组中查找元素的第一个和最后一个位置34M();

        /**
         * 在有重复元素的非递减数组nums中找到目标元素第一次出现的位置和最后一次出现的为位置
         * 若未找到目标值，则返回-1
         */
        ArrayUtils.print(main.searchRange(new int[]{5,7,7,8,8,10},8));//[3,4]
        ArrayUtils.print(main.searchRange(new int[]{5,7,7,8,8,10},6));//[-1,-1]
        ArrayUtils.print(main.searchRange(new int[]{},0));//[-1,-1]
    }
}
