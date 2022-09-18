package A未完成.双指针;

import java.util.Arrays;

public class 满足条件的子序列数目1498H_幂的溢出范围 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        int ans = 0,n=nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i=1;i<n;i++){
            pow[i] = pow[i-1]*2 % 1000000007;
        }
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                ans += pow[right - left];
                // ans += fastPow(2,right-left);
                ans %= 1000000007;
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }

    private long fastPow(int _x, int n){ // 快速幂算法
        long res = 1, x= _x;
        int MOD = 1000000007;
        while(n>0){
            if((n&1)==1) res = (res * x) % MOD;
            x= (x*x) % MOD;
            n>>=1;
        }
        return res%MOD;
    }


    /**
     * 子序列的计算方法：数组nums个数为n个，则从第0到第n-1个元素可组成子序列个数为2的n次方个
     * （n个元速，每个元素可有可没有，两种可能)
     */
    public static void main(String[] args) {
        满足条件的子序列数目1498H_幂的溢出范围 main = new 满足条件的子序列数目1498H_幂的溢出范围();

        /**
         * 给定数组nums和目标值target，返回子序列中最大值和最小值之和小于等于target的子序列种数
         * 数据值很大，大于2的1000次方，最终结果膜除1e9+7
         */
        System.out.println(main);
    }
}
