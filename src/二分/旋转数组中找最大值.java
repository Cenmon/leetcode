package 二分;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 旋转数组中找最大值 {

    public int search(int[] nums){
        int low=0,high=nums.length-1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]) return mid;
                //考虑到当两个元素时，由于下取值，low=mid,而较大值在high位置（由第一个判定可知），此时应该low=mid+1
            else if(nums[low] <= nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        旋转数组中找最大值 main = new 旋转数组中找最大值();

        int[] ints = new int[]{1,2,3,1};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(ints);
        int index = main.search(ints);
        System.out.println("res = " + index + ",value = " + ints[index]);
    }
}
