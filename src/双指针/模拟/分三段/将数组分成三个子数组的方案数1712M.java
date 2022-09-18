package 双指针.模拟.分三段;

public class 将数组分成三个子数组的方案数1712M {

    /**
     * 题目即将数组切割两刀，分成三个子数组，要求三个子数组和依次递增或相等
     */
    // 分割问题：区间和，前缀数组
    public int waysToSplit(int[] nums) {
        int n = nums.length,ans=0;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++) pre[i] = pre[i-1] + nums[i];

        // i为第一刀的下标,j为第二刀的最小可能下标，k为第二刀的最大可能下标
        int j=0,k=0;
        for(int i=0;i<n;i++){
            while (j<=i || j<n && pre[j] - pre[i] < pre[i]){ // left段等于mid段时，mid的右边界下标最小
                j++;
            }
            if(j == n) break;

            while(k+1<n-1 && pre[k+1] - pre[i] <= pre[n-1] - pre[k+1]){ // mid段等于right段时，mid的右边界下标最大
                k++;
            }

            if(k >= j) {
                ans = (ans + k-j+1) % 1000000007;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        将数组分成三个子数组的方案数1712M main = new 将数组分成三个子数组的方案数1712M();

        /**
         * 给定数组，要求将数组分成三个子数组left,mid,right，
         * 且left子数组的元素和小于或等于mid的，mid的小于或等于right的
         * 返回总共有多少中划分方案
         */
        System.out.println(main.waysToSplit(new int[]{1,1,1})); // 1
        /**
         * 1 | 2 | 2,2,5,0
         * 1 | 2,2 | 2,5,0
         * 1,2 | 2,2 | 5,0
         */
        System.out.println(main.waysToSplit(new int[]{1,2,2,2,5,0})); // 3
        System.out.println(main.waysToSplit(new int[]{3,2,1})); // 0
        System.out.println(main.waysToSplit(new int[]{0,3,3})); // 1
        System.out.println(main.waysToSplit(new int[]{0,0,0,0})); // 3

    }
}
