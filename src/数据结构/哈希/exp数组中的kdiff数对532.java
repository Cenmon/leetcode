package 数据结构.哈希;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Cenmo
 * @Date 2022-07-07 2022-07-07
 */
public class exp数组中的kdiff数对532 {

    public int findPairs(int[] nums, int k) { // 固定右端点
        Arrays.sort(nums);
        int i=0,ans=0;
        for(int j=0,n=nums.length;j<n;j++){
            while(i<n && nums[j]-nums[i] > k) i++;
            if(i<j && nums[j] - nums[i] == k){
                ans++;
                while(++i<n && nums[j] - nums[i] == k); // 去重
            }
        }
        return ans;
    }

    public int findPairs2(int[] nums, int k){ // hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for(int num : map.keySet()){

            if(num-k != num && map.containsKey(num-k)){
                ans++;
            }else if(num-k == num && map.get(num)>1){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        exp数组中的kdiff数对532 main = new exp数组中的kdiff数对532();

        /**
         * 给一个数组和k值，找到数组中差值为k的数值对，但不能用自身值，且去除重复对
         */
        System.out.println(main.findPairs(new int[]{3, 1, 4, 1, 5},2)); // 2
        System.out.println(main.findPairs(new int[]{1, 2, 3, 4, 5},1)); // 4
        System.out.println(main.findPairs(new int[]{1, 3, 1, 5, 4},0)); // 1
        System.out.println(main.findPairs(new int[]{1, 1, 1, 1, 1},0)); // 1
    }
}
