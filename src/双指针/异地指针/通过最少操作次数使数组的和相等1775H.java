package 双指针.异地指针;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-08 10:32
 * @Description
 */
public class 通过最少操作次数使数组的和相等1775H {

     public int minOperations(int[] nums1, int[] nums2) {
         int sum1 = getSum(nums1);
         int sum2 = getSum(nums2);
         if(sum2 > sum1){ // 保证nums1的和大于nums2的和
             return minOperations(nums2,nums1);
         }

         Arrays.sort(nums1);
         Arrays.sort(nums2);
         int i=nums1.length-1,j=0,ans=0,n2=nums2.length;
         int diff = sum1 - sum2;
         while(diff > 0){
             if(i<0 && j>=n2) return -1; // nums1减到最小，num2加到最大，但两者的差
             if(i < 0){ // 减到最小
                 diff -= 6-nums2[j++]; // nums2[j]增加到6
             }else if(j>= n2){ // 加到最大
                 diff -= nums1[i--]-1; // nums1[i]减到1
             }else if(nums1[i]-1 > 6-nums2[j]){ // 减到1 或 加到6，哪个对两数组的差贡献最大则进行哪个
                 diff -= nums1[i--]-1;
             }else{
                 diff -= 6-nums2[j++];
             }
             ans++;
         }
         return ans;
     }

    public int minOperations2(int[] nums1, int[] nums2) {
        int sum1 = getSum(nums1);
        int sum2 = getSum(nums2);
        if(sum1 > sum2) return minOperations2(nums2,nums1); // 保证nums1小
        int[] cnt = new int[6];
        for(int num : nums1) cnt[6-num]++; // num1涨到6
        for(int num : nums2) cnt[num-1]++; // num2减到1
        int ans = 0,diff = sum2 - sum1;
        for(int i=5;i>=0;i--){
            while(diff>0 && cnt[i]>0){
                ans++;
                diff -= i;
                cnt[i] --;
            }
        }
        return diff>0 ? -1 : ans;
    }

    private int getSum(int[] nums){
        int sum = 0;
        for(int num : nums) sum+=num;
        return sum;
    }


    public static void main(String[] args) {
        通过最少操作次数使数组的和相等1775H main = new 通过最少操作次数使数组的和相等1775H();

        /**
         * 给定数组nums1,nums2,两者值的范围为1-6，每次可在任意数组中替换成1-6之间任意数
         * 返回使nums1，nums2和相等的最少替换次数
         */



        System.out.println(main.minOperations(new int[]{1,2,3,4,5,6},new int[]{1,1,2,2,2,2})); // 3
        System.out.println(main.minOperations(new int[]{1,1,1,1,1,1,1},new int[]{6})); // -1
        System.out.println(main.minOperations(new int[]{6,6},new int[]{1})); // 3
    }
}
