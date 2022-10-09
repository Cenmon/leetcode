package 二分.旋转数组;

/**
 * @Author Cenmo
 * @Date 2022-10-09 17:34
 * @Description
 */
public class 寻找旋转排序数组中的最小值二154H {

    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        // 去掉末尾与nums[0]重复的元素，保证左单调区间值大于等于nums[0]，右单调区间值严格小于nums[0]
        while(right>0 && nums[right] == nums[0]) right--;
        if(nums[left] < nums[right]) return nums[left]; // 升序数组

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left]; // left、right收敛至left=right
    }


    public static void main(String[] args) {
        寻找旋转排序数组中的最小值二154H main = new 寻找旋转排序数组中的最小值二154H();

        /**
         * 有重复值的旋转数组中找最小值，注升序序列也是一种旋转数组
         */
        System.out.println(main.findMin(new int[]{1,3,5})); // 1
        System.out.println(main.findMin(new int[]{2,2,2,0,1})); // 0
        System.out.println(main.findMin(new int[]{1})); // 1
        System.out.println(main.findMin(new int[]{1,2,1})); // 1
    }
}
