package 双指针.对撞指针.两数之和;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-08-23 2022-08-23
 * @Description
 */
public class 数对和_面1624M {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int left=0,right=nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                ans.add(Arrays.asList(nums[left],nums[right]));
                left++;right--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        数对和_面1624M main = new 数对和_面1624M();

        /**
         * 找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
         */
        JavaUtils.print(main.pairSums(new int[]{5},1));
        JavaUtils.print(main.pairSums(new int[]{5,6,5},11));
        JavaUtils.print(main.pairSums(new int[]{5,6,5,6},11));
    }
}
