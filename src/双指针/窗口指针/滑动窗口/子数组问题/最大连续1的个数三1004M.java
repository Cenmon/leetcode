package 双指针.窗口指针.滑动窗口.子数组问题;

/**
 * @Author Cenmo
 * @Date 2022-10-02 11:05
 * @Description
 */
public class 最大连续1的个数三1004M {

    // 子数组问题：滑动窗口，固定左窗口，思考右窗口
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int j=0,flipZero=0,ans=0;
        for(int i=0;i<n;i++){
            while(j<n && ( nums[j]==1 || flipZero < k) ){
                if(nums[j] == 0) flipZero++;
                j++;
            }
            ans = Math.max(ans,j-i);
            if(j >= n) break;
            while(nums[i] == 1) i++; // 期间的1直接略过
            flipZero--;
        }
        return ans;
    }


    public static void main(String[] args) {
        最大连续1的个数三1004M main = new 最大连续1的个数三1004M();

        /**
         * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
         */
        System.out.println(main.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2)); // 6 [1,1,1,0,0,1,1,1,1,1,1]
        System.out.println(main.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3)); // 10 [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
        System.out.println(main.longestOnes(new int[]{0,0,0,1},4)); // 4 [1,1,1,1]
    }
}
