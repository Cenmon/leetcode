package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-10 22:59
 * @Description
 */
public class 寻找峰值162M {

    public int findPeakElement(int[] nums) {
        // if(nums.length == 1) return 0;
        // if(nums.length == 2) return nums[0]>nums[1]?0:1;
        int left=0,right=nums.length-1;
        // 最右二分:假设nums[-1]和nums[n]均为无穷小
        while(left <= right){
            int mid = left + (right-left)/2;
            // if(mid == 0) break;
            if(mid == 0 || nums[mid] > nums[mid-1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        寻找峰值162M main = new 寻找峰值162M();

        /**
         * 峰值元素是指其值严格大于左右相邻值的元素。
         * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
         * 你可以假设 nums[-1] = nums[n] = -∞ 。
         * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
         */
        System.out.println(main.findPeakElement(new int[]{1,2,3,1}));// 2
        System.out.println(main.findPeakElement(new int[]{1,2,1,3,5,6,4})); // 5
        System.out.println(main.findPeakElement(new int[]{1})); // 0
        System.out.println(main.findPeakElement(new int[]{1,2})); // 1
        System.out.println(main.findPeakElement(new int[]{1,2,3})); // 2
        System.out.println(main.findPeakElement(new int[]{6,5,4,3,2,3,2})); // 0
    }
}
