package 双指针.快慢指针.移除元素;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 删除有序数组的重复元素 {

    public int[] removeDuplicates(int[] nums) {
        int slow=0,fast=1;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        int[] res = new int[slow + 1];
        for(int i=0;i<=slow;i++){
            res[i] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        删除有序数组的重复元素 main = new 删除有序数组的重复元素();
        ArrayUtils.print(main.removeDuplicates(new int[] {1,1,2}));
        ArrayUtils.print(main.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}
