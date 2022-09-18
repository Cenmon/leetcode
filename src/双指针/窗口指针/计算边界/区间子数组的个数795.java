package 双指针.窗口指针.计算边界;

/**
 * @author Cenmo
 * @Date 2022-07-17 2022-07-17
 */
public class 区间子数组的个数795 {

    /**
     * 子数组最大元素在[left,right]中，则子数组元素值域为(-,right]，且必有一个元素值在[left,right]中
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length,ans = 0;
        int slow=-1,fast=0,moreLeft=-1;
        while(fast < n){
            if(nums[fast] <= right){
                if(nums[fast] >= left){
                    moreLeft = fast;
                    ans += fast - slow;
                }else{
                    ans += moreLeft - slow;
                }
            }else{
                slow = fast;
                moreLeft = fast;
            }
            fast++;
        }
        return ans;
    }

    public static void main(String[] args) {
        区间子数组的个数795 main = new 区间子数组的个数795();

        /**
         * 给出数组和上下边界
         * 找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组个数
         */
        System.out.println(main.numSubarrayBoundedMax(new int[]{2,1,4,3},2,3));
        System.out.println(main.numSubarrayBoundedMax(new int[]{2,1,1,2,4,1,3},2,3));
        System.out.println(main.numSubarrayBoundedMax(new int[]{2,9,2,5,6},2,8));
        System.out.println(main.numSubarrayBoundedMax(new int[]{16,69,88,85,79,87,37,33,39,34},55,57));
    }
}
