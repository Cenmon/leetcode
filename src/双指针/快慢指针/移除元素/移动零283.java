package 双指针.快慢指针.移除元素;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 移动零283 {

    public int[] moveZeroes(int[] nums) {
        int n = nums.length,slow=0;
        for(int fast=0;fast < n;fast++){
            if(nums[fast] != 0){
                swap(nums,slow++,fast);
            }
        }
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        移动零283 main = new 移动零283();

        /**
         * 移动0至元素一侧
         */
        ArrayUtils.print(main.moveZeroes(new int[]{0,1,0,3,12})); // 1,3,12,0,0
    }
}
