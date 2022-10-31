package 数据结构.哈希.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-30 20:05
 * @Description
 */
public class 使数组和能被P整除1590M {

    public int minSubarray(int[] nums, int p) {
        //presum[j]-presum[i]=total-np
        // presum[j]%p = (presum[i]+total) % p
        long total = 0;
        for(int num : nums) total+=num;
        if(total % p == 0) return 0;
        if(total < p) return -1;

        long sum=0;
        int n=nums.length,ans = n;
        // int[] map = new int[p+1];
        // map[(int)(total%p)] = 1;
        Map<Long,Integer> map = new HashMap<>();
        map.put(total%p,0);
        for(int i=0;i<n;i++){
            sum += nums[i];
            if( map.containsKey(sum%p) ){
                ans = Math.min(ans,i+1-map.get(sum%p));
                // if( map[(int)(sum%p)]>0 ){
                // ans = Math.min(ans,i+2-map[(int)(sum%p)]);
            }
            // map[(int)((sum+total)%p)] = i+2;
            map.put((sum+total)%p,i+1); // 最右下标
        }
        // System.out.println(map);
        return ans == n ? -1 : ans;
    }


    public static void main(String[] args) {
        使数组和能被P整除1590M main = new 使数组和能被P整除1590M();

        /**
         *给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
         *
         * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
         */
        System.out.println(main.minSubarray(new int[]{3,1,4,2},6));//1
        System.out.println(main.minSubarray(new int[]{6,3,5,2},9));//2
        System.out.println(main.minSubarray(new int[]{1000000000,1000000000,1000000000},3));//0
        System.out.println(main.minSubarray(new int[]{4,4,2},7));//-1
        System.out.println(main.minSubarray(new int[]{4,5,8,5,4},7));//1
        System.out.println(main.minSubarray(new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3},26));//3
    }
}
