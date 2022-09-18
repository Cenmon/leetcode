package 双指针.快慢指针.移除元素.模拟栈;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-08-22 2022-08-22
 * @Description 两端模拟栈：保证相对位置
 */
public class 根据给定数字划分数组2161M {

    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length,top1=0,top2=n-1;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] < pivot){
                ans[top1++] = nums[i];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i] > pivot){
                ans[top2--] = nums[i];
            }
        }
        for(int i=top1;i<=top2;i++){
            ans[i] = pivot;
        }

        return ans;
    }


    public static void main(String[] args) {
        根据给定数字划分数组2161M main = new 根据给定数字划分数组2161M();

        /**
         * 给定数组nums和中心值pivot，将数组中小于pivot放左边，大于pivot放右边，并保证其相对位置
         */
        ArrayUtils.print(main.pivotArray(new int[]{9,12,5,10,14,3,10},10)); // [9,5,3,10,10,12,14]
        ArrayUtils.print(main.pivotArray(new int[]{-3,4,3,2},2)); // [-3,2,4,3]
        ArrayUtils.print(main.pivotArray(new int[]{19,15,12,-14,8,-7,-11},-7)); // [-14,-11,-7,19,15,12,8]
    }
}
