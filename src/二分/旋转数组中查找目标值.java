package 二分;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 旋转数组中查找目标值 {

    public int search (int[] nums, int target) {
        int maxIndex = searchMax(nums);
        System.out.println("maxIndex = " + maxIndex);
        if(target == nums[maxIndex]) return maxIndex;

        if(nums[0] <= target && target <= nums[maxIndex]){
            return searchTarget(nums,0,maxIndex-1,target);
        }else {
            return searchTarget(nums,maxIndex+1,nums.length-1,target);
        }
    }

    public int searchMax(int[] nums){
        int low=0,high=nums.length-1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]) return mid;
            //考虑到两个元素时，由于下取值，low=mid,而较大值在high位置（由第一个判定可知），此时应该low=mid+1
            else if(nums[low] <= nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public int searchTarget(int[] nums,int low,int high,int target){ // 返回目标元素的下标
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) high = mid-1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        旋转数组中查找目标值 main = new 旋转数组中查找目标值();

//        int[] arr = new int[]{6,8,10,0,2,4};
//        int[] arr = new int[]{1,2,3,1};
        int[] arr = new int[]{283,284,287,289,290,293,294,296,298,299,1,5,6,7,9,10,254,255,259,263,266,268,276};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(arr);
        int maxIndex = main.searchMax(arr);
        System.out.println("maxIndex = " + maxIndex);
//        int res = main.search(arr, 108); //2
//        int res = main.search(arr, 3); //-1

//        System.out.println("res = " + res);
    }
}
