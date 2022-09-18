package 数据结构.哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-06-27 2022-06-27
 */
public class 三数之和 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums,int target) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] > target){
                break;
            }else if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }else{
                twoSum(nums,i+1,nums.length-1,target-nums[i]); // 转化为有序数组的两数之和，可借助双指针
            }
        }
        return ans;
    }

    private void twoSum(int[] nums, int left, int right, int target) {
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[left]);
                list.add(nums[right]);
                ans.add(list);

                do {
                    left++;
                }while(left < nums.length && nums[left] == nums[left-1]);
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
    }

    /**
     * 找到三数和为特定值的所有组合，且去除重复组合
     * @param args
     */
    public static void main(String[] args) {
        三数之和 main = new 三数之和();

//        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        List<List<Integer>> lists = main.threeSum(new int[]{-1,0,1,2,-1,-4}, 0); // [[-1,-1,2],[-1,0,1]]
        List<List<Integer>> lists = main.threeSum(new int[]{}, 0); // [[-1,-1,2],[-1,0,1]]
        System.out.println("ans:");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
