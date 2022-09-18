package 双指针.窗口指针.三指针;

/**
 * @author Cenmo
 * @Date 2022-07-31 2022-07-31
 */
public class 有序数组的平方977E {

    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1;
        int[] ans = new int[nums.length];
        for(int idx = nums.length-1;left <= right;idx--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                ans[idx] = nums[left] * nums[left];
                left++;
            }else{
                ans[idx] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        有序数组的平方977E main = new 有序数组的平方977E();
    }
}
