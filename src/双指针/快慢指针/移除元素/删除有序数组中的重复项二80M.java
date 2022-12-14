package 双指针.快慢指针.移除元素;

import Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-08-28 10:44
 * @Description
 */
public class 删除有序数组中的重复项二80M {

    public int[] removeDuplicates(int[] nums) {
        int top=-1;
        for(int x : nums){
            if(top < 1 || x != nums[top]){ // 栈中元素个数小于2或遍历元素不等于栈顶元素
                nums[++top] = x;
            }else if(x != nums[top-1]){ // 栈内元素大于2 且 遍历元素不等于第二个栈顶元素
                nums[++top] = x;
            }
        }
        return Arrays.copyOf(nums,top+1);
    }

    private int[] func(int[] nums){
        int top = 1; // 前两个元素必定入栈
        for(int i=2,n=nums.length;i<n;i++){
            if(nums[i] != nums[top] || nums[i] != nums[top-1]){
                nums[++top] = nums[i];
            }
        }
        return Arrays.copyOf(nums,top+1);
    }


    public static void main(String[] args) {
        删除有序数组中的重复项二80M main = new 删除有序数组中的重复项二80M();

        /**
         * 给定有序数组nums,删除数组中重复项，使得重复项最多出现2次
         */
        ArrayUtils.print(main.removeDuplicates(new int[]{1,1,1,2,2,3})); //[1,1,2,2,3]
        ArrayUtils.print(main.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3})); // [0,0,1,1,2,3,3]

        ArrayUtils.print(main.func(new int[]{1,1,1,2,2,3})); //[1,1,2,2,3]
        ArrayUtils.print(main.func(new int[]{0,0,1,1,1,1,2,3,3})); // [0,0,1,1,2,3,3]
    }
}
