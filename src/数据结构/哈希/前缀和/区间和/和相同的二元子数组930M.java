package 数据结构.哈希.前缀和.区间和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-02 10:28
 * @Description 滑动窗口遍历所有子数组
 */
public class 和相同的二元子数组930M {
    // 99%内存
    public int numSubarraysWithSum3(int[] nums, int goal) {
        int n=nums.length,ans = 0;

        int[] postZero = new int[n]; // 每个下标右侧的0的个数
        int count = 0;
        for(int i=n-1;i>=0;i--){
            postZero[i] = count;
            if(nums[i] == 0){
                count ++;
            }else{
                count = 0;
            }
        }

        int j=0,sum=0; // j右边界，sum为数组nums[i:j]的和
        for(int i=0;i<n;i++){ // i左边界
            while(j<=i || j<n && sum < goal){ // 保证j始终在i的右侧，j-1始终大于0
                sum += nums[j++];
            }
            if(sum == goal) {
                // j必定指向非0元素,j-1后面的0和j后面的0是一样的，此处j-1配合j>i,为了数组不越界
                ans += postZero[j-1]+1;
            }
            sum -= nums[i];
        }
        return ans;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) { // 固定右端点：未解决
        int i=0,sum=0,ans=0;
        for(int j=0,n=nums.length;j<n;j++){
            sum += nums[j];
            if(sum > goal) {
                sum -= nums[i++];
            }
            if(sum == goal){
                ans++;
            }
        }
        return ans;
    }
    // 43%内存
    public int numSubarraysWithSum(int[] nums, int goal) { // hashmap + 前缀和
        // presum[j]-presum[i] = goal -> presum[j] = presum[i]+goal
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0,ans = 0;
        map.put(goal,1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum)){
                ans += map.get(sum);
            }
            map.put(sum+goal,map.getOrDefault(sum+goal,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        和相同的二元子数组930M main = new 和相同的二元子数组930M();

        /**
         * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
         * 子数组 是数组的一段连续部分。
         */
        System.out.println(main.numSubarraysWithSum(new int[]{1,0,1,0,1},2)); // 4
        System.out.println(main.numSubarraysWithSum(new int[]{0,0,0,0,0},0)); // 15
    }
}
