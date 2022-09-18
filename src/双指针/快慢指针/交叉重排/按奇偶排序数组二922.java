package 双指针.快慢指针.交叉重排;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-07-31 2022-07-31
 */
public class 按奇偶排序数组二922 {

    public int[] sortArrayByParityII(int[] nums) {
        int even=0,odd=1,n=nums.length;
        while(true){
            /**
             * 不满足题意的数组值交换
             */
            while(even<n && nums[even]%2 == 0) even+=2;
            while(odd<n && nums[odd]%2 == 1) odd+=2;
            if(even >= n || odd >= n) break;
            swap(nums,even,odd);
        }
        return nums;
    }

    private void swap(int[] nums,int left,int right){
        nums[left] ^= nums[right];
        nums[right] ^= nums[left];
        nums[left] ^= nums[right];
    }

    public static void main(String[] args) {
        按奇偶排序数组二922 main = new 按奇偶排序数组二922();

        /**
         * 给定一个数组，长度为偶数，数组值一半奇一半偶，交叉排序使得奇数下标数组值为奇数，偶数下标数组值为偶数
         */
        ArrayUtils.print(main.sortArrayByParityII(new int[]{4,2,5,7})); // 4,5,2,7
        ArrayUtils.print(main.sortArrayByParityII(new int[]{2,3})); // 2,3
        ArrayUtils.print(main.sortArrayByParityII(new int[]{5,7,4,2})); // 2,7,4,5
    }
}
