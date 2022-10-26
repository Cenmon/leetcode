package 数据结构.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-26 19:34
 * @Description
 */
public class 和等于k的最长子数组长度325M {

    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        Map<Integer,Integer> map = new HashMap<>(); // 记录sum-首次出现时的下标
        map.put(0,-1);
        int sum = 0,ans = 0;
        // presum[i]-presum[j] = k -> presum[i]-k = presum[j]
        // 即扫描前缀和扫到i时，检测i之前是否存在presum[i]-k
        // 注：该题数组值存在负数，前缀和不单调，无法二分，故用hashmap
        for(int i=0,n=nums.length;i<n;i++){
            sum += nums[i];
            if(!map.containsKey(sum)) map.put(sum, i);
            if(map.containsKey(sum-k)) ans = Math.max(ans,i-map.get(sum-k));
        }
        return ans;
    }


    public static void main(String[] args) {
        和等于k的最长子数组长度325M main = new 和等于k的最长子数组长度325M();

        /**
         *  给一个数组nums和目标值k，找到数组中最长的子数组，使其中的元素和为k。如果没有，则返回0。
         *  注：数组nums的值有负数
         */
        System.out.println(main.maxSubArrayLen(new int[]{-2, -1, 2, 1},1)); // 2
        System.out.println(main.maxSubArrayLen(new int[]{1, -1, 5, -2, 3},3)); // 4
    }
}
