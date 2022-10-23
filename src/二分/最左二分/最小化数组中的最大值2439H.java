package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-23 17:38
 * @Description
 */
public class 最小化数组中的最大值2439H {

    public int minimizeArrayValue(int[] nums) {
        // 经过变换后最大值范围为sum(num)/n ~ max(num)
        long left=0,right=nums[0];
        for(int num :nums){
            if(num > right) right = num;
            left += num;
        }
        left /= nums.length;
        while(left <= right){
            long mid = left +(right-left)/2;
            // 能否经过若干变换后使得数组最大值为mid
            if(canMax(nums,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return (int)left;
    }

    private boolean canMax(int[] nums,long max){
        long sum = 0;
        for(int i=0,n=nums.length;i<n;i++){
            // if(nums[i] > max){ // nums[i]大于max,则大于部分全部往左移动
            if(nums[i] - max > i*max-sum) // i*max-sum为左侧全部变为max留下的空位
                return false;
            // }
            sum += nums[i];
        }
        return true;
    }


    public static void main(String[] args) {
        最小化数组中的最大值2439H main = new 最小化数组中的最大值2439H();

        /**
         * 给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。
         *
         * 每一步操作中，你需要：
         *
         * 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。
         * 将 nums[i] 减 1 。
         * 将 nums[i - 1] 加 1 。
         * 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。
         */
        System.out.println(main.minimizeArrayValue(new int[]{3,7,1,6})); // 5
        System.out.println(main.minimizeArrayValue(new int[]{10,1})); // 10
    }
}
