package 二分.最左二分.第K小.二分搜值;

import java.util.Arrays;

public class 找出第K小的数对距离719H {

    /**
     * 求第K小，可用二分法或快排，二分法确定所有数值的最大和最小值后，计算小于等于中值的数值对个数，再进一步二分
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0,right=nums[nums.length-1]-nums[0];
        while(left <= right){
            int mid = left + (right - left) / 2;
            // 最左二分：距离小于等于mid的个数
            if(countLessAndEqual(nums,mid) >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    // 找到区间[i,j],nums[j]-nums[i]==dis,则由于数组有序，增大i的同时dis减小，以j结尾的区间差均小于dis
    private int countLessAndEqual(int[] nums,int dis){
        int i=0,ans=0;
        for(int j=0,n=nums.length;j<n;j++){
            // 0-j之间找到第一个数对差小于等于dis的
            while(nums[j]-nums[i] > dis){
                i++;
            }
            ans += j-i;
        }
        return ans;
    }


    public static void main(String[] args) {
        找出第K小的数对距离719H main = new 找出第K小的数对距离719H();

        /**
         * 给定数组以及数字k，求差的绝对值第k小的的数值对，返回数值对的差
         */
        System.out.println(main.smallestDistancePair(new int[]{1,3,1},1)); // 0 数值对有[1,3],[1,1],[3,1]，第一小的则是[1,1],差值为0
        System.out.println(main.smallestDistancePair(new int[]{1,1,1},2)); // 0
        System.out.println(main.smallestDistancePair(new int[]{1,6,1},3)); // 5
    }
}
