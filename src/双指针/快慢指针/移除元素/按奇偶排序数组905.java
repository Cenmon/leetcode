package 双指针.快慢指针.移除元素;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-07-30 2022-07-30
 */
public class 按奇偶排序数组905 {

    public int[] sortArrayByParity2(int[] nums) { // 移除元素思想
        for(int left=0,right=0;right<nums.length;right++){
            if(nums[right] % 2 == 0){
                // nums[left] ^= nums[right];
                // nums[right] ^= nums[left];
                // nums[left] ^= nums[right];
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
        }
        return nums;
    }

    public int[] sortArrayByParity(int[] nums) { // 快排思想
        int left=0,right=nums.length-1;
        int pivot=nums[0];
        while(left < right){
            while(left < right && nums[right]%2 == 1) right--;
            nums[left] = nums[right];
            while(left < right && nums[left]%2 == 0) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return nums;
    }

    public static void main(String[] args) {
        按奇偶排序数组905 main = new 按奇偶排序数组905();

        ArrayUtils.print(main.sortArrayByParity2(new int[]{3,1,2,4}));
        ArrayUtils.print(main.sortArrayByParity2(new int[]{0}));
        ArrayUtils.print(main.sortArrayByParity2(new int[]{0,2})); // 异或交换元素会发生错误？？？

        
    }
}
