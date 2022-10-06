package 双指针.窗口指针.滑动窗口;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-10-06 20:01
 * @Description 反向固定右端点
 */
public class 按位或最大的最小子数组长度2411H {

    // 反向固定右端点
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] cnt = new int[32];
        for(int i=n-1,j=n-1;i>=0;i--){
            for(int k=0;k<32;k++){
                cnt[k] += ((nums[i] >> k) & 1); // 倒数第k位是0还是1
            }

            while(j>i && canLeft(cnt,nums[j])){
                for(int k=0;k<32;k++){
                    cnt[k] -= ((nums[j] >> k) & 1); // 出队
                }
                j--;
            }
            ans[i] = j-i+1;
        }
        return ans;
    }

    private boolean canLeft(int[] cnt,int num){
        for(int k=0;k<32;k++){
            // 最终倒数第k位为1(cnt[k]>0) 且这个1由当前num提供，则不能左移右端口
            if(cnt[k] == 1 && ((num >> k) & 1) == 1){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        按位或最大的最小子数组长度2411H main = new 按位或最大的最小子数组长度2411H();

        /**
         * 给定数组nums,要求返回一个同样大小的数组ans
         * ans[i]表示nums从i位置开始，长度为ans[i]的子数组内所有元素的按位或结果最大
         * 即找到nums中每个元素开始，连续k个元素按位或结果最大，返回ans
         */
        ArrayUtils.print(main.smallestSubarrays(new int[]{1,0,2,1,3})); //[3,3,2,2,1]
        ArrayUtils.print(main.smallestSubarrays(new int[]{1,2}));//[2,1]
    }
}
