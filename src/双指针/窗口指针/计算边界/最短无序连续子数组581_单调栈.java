package 双指针.窗口指针.计算边界;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-09 2022-07-09
 */
public class 最短无序连续子数组581_单调栈 {

    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int[] sortNums = Arrays.copyOfRange(nums,0,n);
        Arrays.sort(sortNums);

        int left=0,right=n-1;
        while(left<n && nums[left] == sortNums[left]) left++;
        while(right>=0 && nums[right] == sortNums[right]) right--;

        return left<right?right-left+1:0;
    }

    public int findUnsortedSubarray(int[] nums) { // 模拟单调栈解法：确定失序元素位置
        int n = nums.length;
        if( n <= 2 ) return 0;
        int incTop=nums[0];
        int left=-1,right=-1;
        for(int i=0;i<n;i++){// 单增确定失序右边界
            if(nums[i] >= incTop){
                incTop = nums[i];
            }else{
                right = i;
            }
        }
        int decTop=nums[n-1];
        for(int i=n-1;i>=0;i--){ // 单减确定左边界
            if(nums[i] <= decTop){
                decTop = nums[i];
            }else{
                left = i; // 失序则确定边界
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        最短无序连续子数组581_单调栈 main = new 最短无序连续子数组581_单调栈();

        /**
         * 寻找一个子数组长度，排序该子数组后，整个数组均有序
         * 给定数组有三种情况，nums = [numA,numB,numC],AC有序，B无序
         */
        System.out.println(main.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15})); // 5
        System.out.println(main.findUnsortedSubarray(new int[]{1,2,3,4})); // 0
        System.out.println(main.findUnsortedSubarray(new int[]{1})); // 0
    }
}
