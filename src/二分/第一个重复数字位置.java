package 二分;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 第一个重复数字位置 {

    public int search (int[] nums, int target) {//有重复数字的二分查找第一个重复数字
        if(nums.length == 0) return -1;
        // write code here
        int low=0,high=nums.length-1,mid;
//        while(low < high){ //二分查找第二种形式写法：判断条件没有等于，循环体内仅两个判断条件
//            mid = (low+high)/2;
//            if(target > nums[mid]){
//                low = mid + 1;
//            }else{
//                high = mid;
//            }
//        }
        while(low <= high){ //二分查找第三种形式写法：判断条件有等于，最终结果取if条件中没有相等的一方
            mid = (low+high) / 2;
            if(target >= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return nums[low] == target?low:-1;
    }

    public static void main(String[] args) {
        第一个重复数字位置 main = new 第一个重复数字位置();

        System.out.println(main.search(new int[]{1,1,2,2,3,3,3,4}, 2)); // 2
    }
}
