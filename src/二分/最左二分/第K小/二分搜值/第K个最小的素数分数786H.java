package 二分.最左二分.第K小.二分搜值;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-10-25 20:27
 * @Description
 */
public class 第K个最小的素数分数786H {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 分数的最小值为0，最大值为1
        double left=0,right=1;
        double mid=(left+right)/2;
        while(left < right){
            mid = (left+right)/2;
            // 计数小于等于mid的分数个数
            // i/j <= value -> i <= value*j (i,j>=1)
            int count = 0;
            for(int j : arr){
                int i = upper_search(arr,mid*j);
                count += i+1;
            }
            if(count > k){
                right = mid; // 往左探测
            }else if(count < k){
                left = mid;
            }else{
                break; // 第k小值可能存在间隙，但下方求对应分数时是求小于等于mid值的最接近值
            }
        }
        // System.out.println(mid);
        int n = arr.length;
        int[] ans = new int[]{-1,1};
        // 求nums[i] <= value*nums[j] 是的i/j的最大值
        for(int j : arr){
            int i = upper_search(arr,j*mid);
            if(i>=0 && arr[i]*1.0/j > ans[0]*1.0/ans[1]){
                ans[0] = arr[i];
                ans[1] = j;
            }
        }
        return ans;
    }

    private int upper_search(int[] arr,double value){
        // 求小于等于value的最右下标：小于等于时往右走
        int left=0,right=arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] <= value){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right; // 输出范围为[-1,n-1]
    }


    public static void main(String[] args) {
        第K个最小的素数分数786H main = new 第K个最小的素数分数786H();

        /**
         * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
         *
         * 对于每对满足 0 <= i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
         *
         * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案,
         * 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
         *
         */
        ArrayUtils.print(main.kthSmallestPrimeFraction(new int[]{1,13,17,59},6));//arrays:[13, 17]
        ArrayUtils.print(main.kthSmallestPrimeFraction(new int[]{1,79},1));//arrays:[1, 79]
        ArrayUtils.print(main.kthSmallestPrimeFraction(new int[]{1,2,3,5},3));//arrays:[2, 5]
        ArrayUtils.print(main.kthSmallestPrimeFraction(new int[]{1,5,17,29,41,43,61,73,83},21));//arrays:[29, 73]
    }
}
