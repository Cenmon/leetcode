package 二分.旋转数组;

/**
 * @Author Cenmo
 * @Date 2022-10-09 16:49
 * @Description
 */
public class 搜索旋转排序数组33M {

    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;
            // 无重复值的旋转数组有两个单调区间，左单调区间值均大于等于nums[0]，右单调区间均小于nums[0]
            if( (nums[mid]>=nums[0]) == (target >= nums[0]) ){ // 在同一个单调区间内
                if(nums[mid] > target){ // 单调区间即可解决问题
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] >= nums[0]){ //mid在左区间，target在右区间
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        搜索旋转排序数组33M main = new 搜索旋转排序数组33M();

        /**
         * 无重复值的旋转数组中找目标值
         */
        System.out.println(main.search(new int[]{4,5,6,7,0,1,2},0)); // 4
        System.out.println(main.search(new int[]{4,5,6,7,0,1,2},3)); // -1
        System.out.println(main.search(new int[]{1},0)); // -1
        System.out.println(main.search(new int[]{1},1)); // 0
    }
}
