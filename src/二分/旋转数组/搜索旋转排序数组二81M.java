package 二分.旋转数组;

/**
 * @Author Cenmo
 * @Date 2022-10-09 17:04
 * @Description
 */
public class 搜索旋转排序数组二81M {

    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        // 去除最右边与nums[0]相等部分
        if(nums[right] == target) return true;
        while(right>=0 && nums[0] == nums[right]) right--; // 留一位判断left=right=0时

        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return true;
            if((nums[mid]>=nums[0]) == (target>=nums[0])){
                if(nums[mid] > target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] >= nums[0]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        搜索旋转排序数组二81M main = new 搜索旋转排序数组二81M();

        /**
         * 有重复值的旋转数组中找目标值,找得到返回true，反之返回false
         */
        System.out.println(main.search(new int[]{2,5,6,0,0,1,2},0)); // true
        System.out.println(main.search(new int[]{2,5,6,0,0,1,2},3)); // false
        System.out.println(main.search(new int[]{1},0)); // false
        System.out.println(main.search(new int[]{1},1)); // true
    }
}
