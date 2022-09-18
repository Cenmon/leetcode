package 双指针.窗口指针.三指针;

import java.util.HashSet;
import java.util.Set;

public class exp算术三元组的数目2367E {

    public int arithmeticTriplets2(int[] nums, int diff) { // hash方法
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);

        int ans = 0;
        for(int x : nums){
            if(set.contains(x+diff) && set.contains(x+2*diff)){
                ans++;
            }
        }
        return ans;
    }

    // @Cenmo:三指针
    /**
     * 由题可得，计算区间应为x,x+diff,x+2*diff,由于diff固定，所以当x变大是，另外两个值也变大
     */
    public int arithmeticTriplets(int[] nums, int diff) { // 三指针
        int ans=0,n=nums.length;
        int i=0,j=0;
        for(int x : nums){
            while(i<n && nums[i] < x+diff) i++;
            if(i<n && nums[i] > x+diff) continue;
            while(j<n && nums[j] < x+2*diff) j++;
            if(j<n && nums[j] == x+2*diff) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        exp算术三元组的数目2367E main = new exp算术三元组的数目2367E();

        /**
         * 给定数组nums和差值diff,要求计算nums元素构成的三元组(i,j,k),i+diff=j,j+diff=k
         * 返回nums能够构成的三元组个数
         */
        System.out.println(main.arithmeticTriplets(new int[]{0,1,4,6,7,10},3)); // 2
        System.out.println(main.arithmeticTriplets(new int[]{4,5,6,7,8,9},2)); // 2
    }
}
