package 数据结构.哈希.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-31 11:52
 * @Description
 */
public class 将x减到0的最小操作数1658M {

    public int minOperations(int[] nums, int x) {
        // presum[j]-presum[i] = total-x,最大的j-i
        long total=0;
        for(int num : nums){
            total += num;
        }
        if(total == x) return nums.length;

        Map<Long,Integer> map = new HashMap<>();
        int ans = 0;
        long sum = 0;
        map.put(total-x,0); // 考虑presum[j]=0的情况
        for(int i=0,n=nums.length;i<n;i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans,i+1-map.get(sum));
            }
            if(!map.containsKey(total+sum-x)){
                map.put(total+sum-x,i+1); //最左
            }
        }
        // System.out.println(map);
        return ans>0?nums.length-ans:-1;
    }


    public static void main(String[] args) {
        将x减到0的最小操作数1658M main = new 将x减到0的最小操作数1658M();

        /**
         *给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
         * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
         *
         * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
         */
        System.out.println(main.minOperations(new int[]{1,1,4,2,3},5));//2
        System.out.println(main.minOperations(new int[]{5,6,7,8,9},4));//-1
        System.out.println(main.minOperations(new int[]{3,2,20,1,1,3},10));//5
        System.out.println(main.minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309},134365));//16
    }
}
