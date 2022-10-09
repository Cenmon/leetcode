package 二分.旋转数组;

/**
 * @Author Cenmo
 * @Date 2022-10-09 17:22
 * @Description
 */
public class 寻找旋转排序数组中的最小值153M {

    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        if(nums[left] < nums[right]) return nums[left];
        // 规定旋转数组由有序数组得到，故本题必定有解，当left、right收敛到left=right时有解
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= nums[0]){
                left = mid+1;
            }else{
                right = mid; // 最小值在右侧？因此mid不减1？
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        寻找旋转排序数组中的最小值153M main = new 寻找旋转排序数组中的最小值153M();

        /**
         * 无重复元素旋转数组中找最小值，注升序数组也是一个旋转数组
         */
        System.out.println(main.findMin(new int[]{3,4,5,1,2}));
        System.out.println(main.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(main.findMin(new int[]{11,13,15,17}));
    }
}
