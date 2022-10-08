package 双指针.对撞指针.两数之差;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-07 2022-07-07
 */
public class exp数组中的kdiff数对532 {

    public int findPairs(int[] nums, int k) { // 两数之差等于特定值：求所有组合，窗口指针
        Arrays.sort(nums);
        int left=0,right=1,n=nums.length;
        int ans = 0;
        while(left < n && right < n){
            int minus = nums[right] - nums[left];
            if(left != right && minus == k){
                ans++;
                while (++left<n && nums[left] == nums[left-1]);
            }else if(minus < k){
                right++;
            }else{
                left++;
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
