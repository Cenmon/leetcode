package 双指针.模拟.扫描区间.差分数组;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-09-16 18:55
 * @Description
 */
public class 所有排列中的最大和1589M {
    // 差分数组：确定各个区间对应的元素的查询频率
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] diff = new int[n];
        for(int[] req : requests){
            diff[ req[0] ] += 1;
            if(req[1]+1 < n)
                diff[ req[1]+1 ] -= 1;
        }
        for(int i=1;i<n;i++){
            diff[i] += diff[i-1];
        }
        Arrays.sort(diff);
        Arrays.sort(nums);
        long ans = 0;
        for(int i=0;i<n;i++){
            ans = (ans + (long)nums[i] * diff[i]) % 1000000007;
        }
        return (int)ans;
    }


    public static void main(String[] args) {
        所有排列中的最大和1589M main = new 所有排列中的最大和1589M();

        /**
         * 给出整数数组nums和请求数组requests，其中 requests[i]表示某个区间，表示下标[start,end]的区间和
         * 确定nums的某个排列，使得所有requests对应的区间和 的和最大
         * 返回最大的和
         */
        System.out.println(main.maxSumRangeQuery(new int[]{1,2,3,4,5},new int[][]{{1,3},{0,1}})); // 19 [4,5,3,2,1]
        System.out.println(main.maxSumRangeQuery(new int[]{1,2,3,4,5,6},new int[][]{{0,1}})); // 11 [6,5,4,3,2,1]
        System.out.println(main.maxSumRangeQuery(new int[]{1,2,3,4,5,10},new int[][]{{0,2},{1,3},{1,1}})); // 47 [6,5,4,3,2,1]
    }
}
