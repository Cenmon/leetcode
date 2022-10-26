package 二分.最左二分.第K小.二分搜值;

/**
 * @Author Cenmo
 * @Date 2022-10-24 18:29
 * @Description
 */
public class 两个有序数组的第K小乘积2040H {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // 乘积的最小值
        int m = nums1.length,n = nums2.length;
        if(m > n) return kthSmallestProduct(nums2,nums1,k);

        long left=-10000000000l,right=10000000000l;
        while(left <= right){
            long mid = left + (right-left)/2;
            // 计数乘积小于等于mid的个数
            if(countLessOrEqual(nums1,nums2,mid) >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private long countLessOrEqual(int[] nums1,int[] nums2,long value){
        long count = 0;
        int n = nums2.length;
        for(int n1 : nums1){
            if(n1 == 0){
                count += value>=0 ? n : 0;
            }else if(n1 < 0){
                double target = value/(double)n1;
                int idx = lower_search(nums2,0,n-1,target);

                count += n-1-idx;// 计算大于value/n1的个数
                if(nums2[idx] >= target) count++;// 计算等于value/n1的个数
            }else{
                double target = value/(double)n1;
                int idx = upper_search(nums2,0,n-1,target);

                count += idx;// 计算小于value/n1的个数
                if(nums2[idx] <= target) count++;// 计算等于value/n1的个数
            }
        }
        return count;
    }

    private int upper_search(int[] nums,int left,int right,double target){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(right < 0) return 0;
        if(right >= nums.length) return nums.length-1;
        return right;
    }

    private int lower_search(int[] nums,int left,int right,double target){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left < 0) return 0;
        if(left >= nums.length) return nums.length-1;
        return left;
    }


    public static void main(String[] args) {
        两个有序数组的第K小乘积2040H main = new 两个有序数组的第K小乘积2040H();

        /**
         *  给你两个 从小到大排好序 且下标从 0 开始的整数数组 nums1 和 nums2 以及一个整数 k ，
         *  数组中元素有正有负
         *  请你返回第 k （从 1 开始编号）小的 nums1[i] * nums2[j] 的乘积，
         *  其中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
         */
        System.out.println(main.kthSmallestProduct(new int[]{2,5},new int[]{3,4},2));//8
        System.out.println(main.kthSmallestProduct(new int[]{-4,-2,0,3},new int[]{2,4},6));//0
        System.out.println(main.kthSmallestProduct(new int[]{-2,-1,0,1,2},new int[]{-3,-1,2,4,5},3));//-6
        System.out.println(main.kthSmallestProduct(new int[]{-8,-6,0,1,4,10},new int[]{-10,-8,-7,-6},19));//48
        System.out.println(main.kthSmallestProduct(new int[]{-9,-4,1,6,8,8,9,10},new int[]{-10,-10,-8,-8,1,3,6,6,8,10},29));//-24
        System.out.println(main.kthSmallestProduct(new int[]{-3,3,4,6,9,10},new int[]{7},5));//63
    }
}
