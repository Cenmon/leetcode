package 数据结构.哈希.前缀和.区间和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-30 16:07
 * @Description
 */
public class 连续数组525M {

    public int findMaxLength2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(); // 2*presum[index]-index & index
        int ans = 0,sum = 0;
        map.put(0,0); // 在前缀和数组版本之后，下标统一向后移以为
        // j-i=2*(presum[j]-presum[i]) -> 2*presum[i]-i = 2*presum[j]-j
        for(int i=0,n=nums.length;i<n;i++){
            sum += nums[i];
            if(!map.containsKey(2*sum-i-1)){
                map.put(2*sum-i-1,i+1);
            }else{
                ans = Math.max(ans,i+1-map.get(2*sum-i-1));
            }
        }
        return ans;
    }

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(); // 2*presum[index]-index & index
        int[] presum = new int[nums.length+1];
        int ans = 0;
        map.put(0,0);
        // j-i=2*(presum[j]-presum[i]) -> 2*presum[i]-i = 2*presum[j]-j
        for(int i=1,n=nums.length;i<=n;i++){
            presum[i] = presum[i-1] + nums[i-1];
            if(!map.containsKey(2*presum[i]-i)){
                map.put(2*presum[i]-i,i);
            }else{
                ans = Math.max(ans,i-map.get(2*presum[i]-i));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        连续数组525M main = new 连续数组525M();

        /**
         * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
         */
        System.out.println(main.findMaxLength(new int[]{0,1})); // 2
        System.out.println(main.findMaxLength(new int[]{0,1,0})); // 2
    }
}
