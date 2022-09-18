package 双指针.对撞指针.两数之和;

/**
 * @Author Cenmo
 * @Date 2022-09-18 23:04
 * @Description
 */
public class 好子数组的最大分数1793H {

    public int maximumScore(int[] nums, int k) {
        int left=k,right=k,n=nums.length;
        int min = nums[k],ans = nums[k];
        while(left>=0 || right<n){
            while(left>=0 && nums[left] >= min){
                left--;
            }
            while(right<n && nums[right] >= min ){
                right++;
            }
            ans = Math.max(ans,min*(right-left-1));
            min = Math.max(left<0?Integer.MIN_VALUE:nums[left],right<n?nums[right]:Integer.MIN_VALUE);
        }
        return ans;
    }

    public static void main(String[] args) {
        好子数组的最大分数1793H main = new 好子数组的最大分数1793H();

        /**
         * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
         * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。
         * 一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
         *
         * 请你返回 好 子数组的最大可能 分数 。
         */
        System.out.println(main.maximumScore(new int[]{1,4,3,7,4,5},3));
        System.out.println(main.maximumScore(new int[]{5,5,4,5,4,1,1,1},0));
    }
}
