package 二分.普通二分;

/**
 * @Author Cenmo
 * @Date 2022-10-20 20:55
 * @Description
 */
public class 特殊数组的特征值1608M {

    public int specialArray(int[] nums) {
        // 特征值最小为0，最大为max(nums)
        int left=0,right=nums[0];
        for(int num : nums){
            if(num > right) right = num;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            // 计算nums中大于等于mid的元素个数
            int count = 0;
            for(int num : nums){
                if(num >= mid){
                    count++;
                }
            }

            if(count < mid){
                right = mid - 1; // 减小mid,同时增大count
            }else if(count > mid){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        特殊数组的特征值1608M main = new 特殊数组的特征值1608M();

        /**
         * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，
         * 那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
         *
         * 注意： x 不必 是 nums 的中的元素。
         *
         * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，
         * 如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
         *
         */
        System.out.println(main.specialArray(new int[]{3,5})); // 2
        System.out.println(main.specialArray(new int[]{0,0})); // -1
        System.out.println(main.specialArray(new int[]{0,4,3,0,4})); // 3
    }
}
