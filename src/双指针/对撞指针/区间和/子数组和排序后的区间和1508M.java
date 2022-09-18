package 双指针.对撞指针.区间和;

public class 子数组和排序后的区间和1508M {

    // @Cenmo:子数组和矩阵
    public int rangeSum(int[] nums, int n, int left, int right) {
        int sum = 0;
        for(int i=0;i<n;i++)
            sum+=nums[i];

        return SmallerOrEqualKSum(nums,n,right,sum) - SmallerOrEqualKSum(nums,n,left-1,sum);
    }

    // 所有小于等于第k小的数组和的和
    // 可以通过矩阵的形式观察所有子数组的和
    private int SmallerOrEqualKSum(int[] nums,int n,int k,int totalSum){
        int kSum = getKthSum(nums,k,0,totalSum);
        System.out.println("k = " + k + " , kSum = " + kSum);
        int sum = 0,ssum = 0,count = 0;
        for(int i=0,j=0;i<n;i++){
            while(j < n && sum + nums[j] < kSum){
                System.out.println("nums[j] = " + nums[j]);
                sum += nums[j];
                ssum += sum;
                j++;
            }
            if(sum > 0) {
                count += j-i;
                sum -= nums[i];
                if(sum < kSum) ssum += sum;
            }
        }
        System.out.println("ssum = " + ssum);
        System.out.println("count = " + count);
        return ssum + (k-count)*kSum;
    }

    private int getKthSum(int[] nums,int k,int slow,int high){ // 计算第k小的子数组和
        while(slow <= high){
            int mid = high - (high - slow) / 2;
            if(SmallerOrEqual(nums,mid) < k){
                slow = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        // System.out.println(k + " , " + slow);
        return slow;
    }

    private int SmallerOrEqual(int[] nums,int value){ // 计算和小于等于value的子数组个数
        int right=0,n=nums.length;
        int count=0,sum = 0;
        // 从left开始的子数组和小于value
        for(int left=0;left < n;left++){
            while(right < n && sum + nums[right] <= value){
                sum += nums[right];
                right++;
            }
            count += right - left;
            sum -= nums[left];
        }
        return count;
    }

    // 注： 子数组和不能排序，否则和值就发生了改变
    public static void main(String[] args) {
        子数组和排序后的区间和1508M main = new 子数组和排序后的区间和1508M();

        /**
         * 给定数组nums,数组大小n，区间left,right
         * 返回数组第left小 到 第right小的子数组和
         */
        System.out.println(main.rangeSum(new int[]{1,2,3,4},4,1,5)); // 13
//        System.out.println(main.rangeSum(new int[]{1,2,3,4},4,3,4)); // 6
//        System.out.println(main.rangeSum(new int[]{1,2,3,4},4,1,10)); // 50
//        System.out.println(main.rangeSum(new int[]{1,2,3,4},4,1,5));
    }
}
