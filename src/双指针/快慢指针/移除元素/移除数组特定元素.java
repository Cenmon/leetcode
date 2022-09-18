package 双指针.快慢指针.移除元素;

import Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class 移除数组特定元素 {

    public int[] removeElement(int[] nums, int val) {
        int top=-1; // 第一个元素是否直接入栈，若不确定是否入栈，则top=-1,若直接入栈，则top=0
        for(int x : nums){
            if(x != val){
                nums[++top] = x;
            }
        }
        return Arrays.copyOfRange(nums,0,top+1);
    }

    public static void main(String[] args) {
        移除数组特定元素 main = new 移除数组特定元素();

        ArrayUtils.print(main.removeElement(new int[]{3,2,2,3},3)); // [2, 2]
        ArrayUtils.print(main.removeElement(new int[]{0,1,2,2,3,0,4,2},2)); // [0, 1, 3, 0, 4]
    }
}
