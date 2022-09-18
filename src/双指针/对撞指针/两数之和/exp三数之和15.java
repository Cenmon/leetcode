package 双指针.对撞指针.两数之和;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-06-27 2022-06-27
 */
public class exp三数之和15 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]*3.0 > 0){
                break;
            }else if(nums[i] + nums[n-1]*2.0 < 0){
                continue;
            }else if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }else{
                twoSum(nums,i+1,n-1,-nums[i]); // 转化为有序数组的两数之和，可借助双指针
            }
        }
        return ans;
    }

    private void twoSum(int[] nums, int left, int right, int target) {
        while(left < right){
            if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                ans.add(Arrays.asList(-target,nums[left],nums[right]));

                while(++left<right && nums[left] == nums[left-1]);
                while(--right>left && nums[right] == nums[right+1]);
            }
        }
    }

    /**
     * 找到三数和为特定值0时的所有三元组组合，且去除重复组合
     * @param args
     */
    public static void main(String[] args) {
        exp三数之和15 main = new exp三数之和15();

        main.ans.clear();
        JavaUtils.print(main.threeSum(new int[]{-1,0,1,2,-1,-4}));// [[-1,-1,2],[-1,0,1]]
        main.ans.clear();
        JavaUtils.print(main.threeSum(new int[]{}));// []
        main.ans.clear();
        JavaUtils.print(main.threeSum(new int[]{0}));// []
    }
}
