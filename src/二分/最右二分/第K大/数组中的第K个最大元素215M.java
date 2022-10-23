package 二分.最右二分.第K大;

/**
 * @Author Cenmo
 * @Date 2022-10-23 19:12
 * @Description
 */
public class 数组中的第K个最大元素215M {

    public int findKthLargest(int[] nums, int k) {
        // 第k大的取值范围为min(nums) ~ max(nums)
        int left=nums[0],right=nums[0];
        for(int num : nums){
            if(num < left) left = num;
            if(num > right) right = num;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            // 大于等于mid的个数
            int count = countGreatAndEqual(nums,mid);
            if(count == k){
                left = mid + 1;
            }else if(count > k){
                left = mid + 1; // 增大mid，即减小count
            }else{
                right = mid - 1; // 减小mid，即增大count
            }
        }
        return right;
    }

    private int countGreatAndEqual(int[] nums,int value){
        int count = 0;
        for(int num : nums){
            if(num >= value){
                count ++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        数组中的第K个最大元素215M main = new 数组中的第K个最大元素215M();

        /**
         * 找出数组中的第K个最大元素
         */
        System.out.println(main.findKthLargest(new int[]{3,2,1,5,6,4},2));// 5
        System.out.println(main.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4)); // 4
    }
}
