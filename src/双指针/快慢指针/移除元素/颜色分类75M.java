package 双指针.快慢指针.移除元素;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 颜色分类75M {

    public int[] sortColors(int[] nums) { // 对撞指针解法：适用于两种颜色分类
        int left=0,right=nums.length-1;
        int i=0;
        while(i<=right){ // 若非如此，扫描到2时会和1互换
            if(nums[i] == 0){
                swap(nums,i,left);
                left++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                swap(nums,i,right);
                right--;
            }
        }
        return nums;
    }

    public int[] sortColors2(int[] nums) { // 移动特定元素解法，适用于多种颜色
        int slow=0,fast=1;
        while (fast < nums.length){ // 第一种颜色分类
            if(nums[fast] == 0){
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }
        fast = slow;
        while (fast < nums.length){ // 第二种颜色分类
            if(nums[fast] == 1){
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }

    private int[] func(int[] nums){
        int top = -1;
        for(int i=0,n=nums.length;i<n;i++){
            if(nums[i] == 0){
                swap(nums,i,++top); // 入栈
            }
        }
        for(int i=top+1,n=nums.length;i<n;i++){
            if(nums[i] == 1){
                swap(nums,i,++top);
            }
        }
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int tmep = nums[i];
        nums[i] = nums[j];
        nums[j] = tmep;
    }

    public static void main(String[] args) {
        颜色分类75M main = new 颜色分类75M();

        ArrayUtils.print(main.sortColors(new int[] {2,0,2,1,1,0})); // 0,0,1,1,2,2
        ArrayUtils.print(main.sortColors(new int[] {2}));// 0,0,1,1,2,2
        ArrayUtils.print(main.sortColors(new int[] {2,0,1})); // 0,1,2

        System.out.println();
        ArrayUtils.print(main.func(new int[] {2,0,2,1,1,0})); // 0,0,1,1,2,2
        ArrayUtils.print(main.func(new int[] {2}));// 2
        ArrayUtils.print(main.func(new int[] {2,0,1})); // 0,1,2
    }
}
