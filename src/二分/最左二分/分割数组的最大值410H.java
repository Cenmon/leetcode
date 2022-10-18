package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-17 16:27
 * @Description k个子数组和是否小于等于value
 */
public class 分割数组的最大值410H {

    public int splitArray(int[] nums, int k) {
        int n = nums.length,max = nums[0],sum = nums[0];
        for(int i=1;i<n;i++){
            sum += nums[i];
            if(nums[i] > max) max = nums[i];
        }
        // 二分搜值：最小值为大小为1的子数组最大值，最大值为大小为n的子数组和
        int left = max,right = sum;
        while(left <= right){
            int mid = left + (right-left) / 2; // mid指向分成m个子数组的最大值
            // k段子数组的和均小于mid
            if(KArraySumSmallThanMid(nums,k,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean KArraySumSmallThanMid(int[] nums,int k,int value){
        int count = 0,n = nums.length,sum = 0;
        int i=0,j=0;
        while( i < n ){
            while(j<n && sum+nums[j] <= value){ // 满足子数组和小于等于value
                sum += nums[j];
                j++;
            }
            count ++;
            i = j;
            sum = 0;
        }
        return count <= k;
    }


    public static void main(String[] args) {
        分割数组的最大值410H main = new 分割数组的最大值410H();

        /**
         * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
         *
         * 设计一个算法使得这 m 个子数组各自和的最大值最小
         */
        System.out.println(main.splitArray(new int[]{7,2,5,10,8},2)); // 18
        System.out.println(main.splitArray(new int[]{1,2,3,4,5},2)); // 9
        System.out.println(main.splitArray(new int[]{1,4,4},3)); // 4
    }
}
