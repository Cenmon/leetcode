package 双指针.对撞指针.两数之和;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-08-22 2022-08-22
 * @Description
 */
public class 采购方案LCP28E {
    // 时间上击败27.88%，空间上10%
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1,ans=0;
        while(left < right){
            if(nums[left] + nums[right] <= target){
                ans = (ans + right - left) % 1000000007;
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        采购方案LCP28E main = new 采购方案LCP28E();

        /**
         * 给定零件价格数组nums,选择两个零件价格之和不大于target，返回可以选择的方案种数
         */
        System.out.println(main.purchasePlans(new int[]{2,5,3,5},6)); // 1
        System.out.println(main.purchasePlans(new int[]{2,2,1,9},10)); // 4
    }
}
