package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-04 20:02
 * @Description 滑动窗口+木桶原理
 */
public class 最高频元素的频数1838M {
    // 思想：即确定某个子数组，花费<=k次将子数组所有元素增加为相同值
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,ans=0,sum=0;
        for(int j=0,n=nums.length;j<n;j++){
            sum += nums[j];
            while(nums[j]*(j-i+1)-sum > k){ // 木桶原理
                sum -= nums[i++];
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        最高频元素的频数1838M main = new 最高频元素的频数1838M();

        /**
         * 元素的 频数 是该元素在一个数组中出现的次数。
         * 给定整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
         * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
         */
        System.out.println(main.maxFrequency(new int[]{1,2,4},5)); // 3
        System.out.println(main.maxFrequency(new int[]{1,4,8,13},5)); // 2
        System.out.println(main.maxFrequency(new int[]{3,9,6},2)); // 1
        System.out.println(main.maxFrequency(new int[]{1,4,8,8,13,13,30},30)); // 5
    }
}
