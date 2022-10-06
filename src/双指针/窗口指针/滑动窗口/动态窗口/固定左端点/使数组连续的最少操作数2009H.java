package 双指针.窗口指针.滑动窗口.动态窗口.固定左端点;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-06 12:19
 * @Description
 */
public class 使数组连续的最少操作数2009H {

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int j=0,ans=Integer.MAX_VALUE;
        int top=0,n=nums.length; // 模拟栈
        for(int i=1;i<n;i++){ // nums[0]已经入栈
            if(nums[i] != nums[top]){
                nums[++top] = nums[i];
            }
        }
        for(int i=0,size=top+1;i<size;i++){
            while(j<size && nums[j]-nums[i]+1 <= n){
                ans = Math.min(ans,n-(j-i+1));
                j++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        使数组连续的最少操作数2009H main = new 使数组连续的最少操作数2009H();

        /**
         * 给定数组nums,每次操作可将任意元素替换成其他任意整数
         * 当数组内所有元素互不相同，且max(nums)-min(nums)+1 == nums.length时，则数组值是连续的
         * 返回使 nums 连续 的 最少 操作次数。
         */
        System.out.println(main.minOperations(new int[]{4,2,5,3})); // 0
        System.out.println(main.minOperations(new int[]{1,2,3,5,6})); // 1
        System.out.println(main.minOperations(new int[]{1,10,100,1000})); // 3
    }
}
