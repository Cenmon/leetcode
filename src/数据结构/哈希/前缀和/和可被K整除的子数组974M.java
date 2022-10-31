package 数据结构.哈希.前缀和;

/**
 * @Author Cenmo
 * @Date 2022-10-30 17:29
 * @Description
 */
public class 和可被K整除的子数组974M {

    public int subarraysDivByK(int[] nums, int k) {
        //presum[j]-presum[i] = nk（n为正数、负数、0）-> (presum[j]-presum[i])%k == 0
        // -> (presum[j]%k - presum[i]%k) % k= 0 -> presum[j]%k = presum[i]%k
        // map保存presum[i]%k ， 搜索presum[j]%k
        int[] map = new int[k];
        int ans = 0,sum = 0;
        map[0] = 1;// presum[i]=0时,presum[j]/k可为任意整数
        for(int num : nums){
            sum += num;

            int key = sum>0 ? sum%k : (sum%k+k)%k;
            ans += map[key];
            map[key]++;
        }
        return ans;
    }


    public static void main(String[] args) {
        和可被K整除的子数组974M main = new 和可被K整除的子数组974M();

        /**
         * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
         *
         * 子数组 是数组的 连续 部分。
         */
        System.out.println(main.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));// 7
        System.out.println(main.subarraysDivByK(new int[]{5},9)); // 0
        System.out.println(main.subarraysDivByK(new int[]{-1,2,9},2)); // 2
        System.out.println(main.subarraysDivByK(new int[]{7,4,-10},5)); // 1
    }
}
