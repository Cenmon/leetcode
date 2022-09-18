package 双指针.异地指针.下一个字典序;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class 下一个排列31 {

    /**
     * 总体思想为末尾大字典序值上浮，难点在于寻找大字典序值和其上浮位置
     * 做法：升序排列字典序最小，故寻找升序对进而确定上浮位置，再确定大字典序值
     * @param nums
     * @return
     */
    public int[] nextPermutation(int[] nums) {
        int i=nums.length - 2;
        // 第一个升序对
        while(i >= 0 && nums[i] >= nums[i+1]) i--;

        if(i == -1) { // 找不到升序对
            inverse(nums,0,nums.length-1);
            return nums;
        }
        int j=nums.length - 1;
        // 升序序列
        while(j > i && nums[j] <= nums[i]) j--;
        // 交换两个端点
        swap(nums,i,j);
        inverse(nums,i+1,nums.length-1);
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void inverse(int[] nums,int left,int right){ // 数组逆置
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        下一个排列31 main = new 下一个排列31();

        /**
         * 返回下一字典序的序列，如nums=[1,2,3],可组成数字123,132,213,321,数字321比123大，故字典序比其大
         * 因此123的下一字典序序列为132
         * 若是最大字典序321，则其下一字典序为123(循环)
         */
        ArrayUtils.print(main.nextPermutation(new int[]{1,2,3})); //132
        ArrayUtils.print(main.nextPermutation(new int[]{3,2,1})); // 123
        ArrayUtils.print(main.nextPermutation(new int[]{1,1,5})); //151

    }
}
