package 双指针.对撞指针.两数之和;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class 四数之和18 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]*4.0 > target) {
                break;
            }else if(nums[i] + nums[n-1]*3.0 < target) {
                continue;
            }else if(i>0 && nums[i] == nums[i-1]){ // 去重
                continue;
            }else{
                threeSum(nums,i+1,n-1,(long)target-nums[i],nums[i]);
            }
        }
        return ans;
    }

    /**
     *
     */
    public void threeSum(int[] nums,int left,int right,long target,int a){
        for(int i=left;i<= right;i++){
            if(nums[i]*3.0 > target){
                break;
            }else if(nums[i] + nums[right]*2.0 < target){
                continue;
            }else if(i>left && nums[i] == nums[i-1]){ // 去重
                continue;
            }else{
                twoSum(nums,i+1,nums.length-1,target-nums[i],a,nums[i]);
            }
        }
    }

    public void twoSum(int[] nums,int left,int right,long target,int a,int b){
        while(left < right){
            long sum = (long)nums[left] + nums[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                ans.add(Arrays.asList(a,b,nums[left],nums[right]));

                while (++left<right && nums[left] == nums[left-1]);
                while (--right>left && nums[right] == nums[right+1]);
            }
        }
    }

    public static void main(String[] args) {
        四数之和18 main = new 四数之和18();

        main.ans.clear();
        JavaUtils.print(main.fourSum(new int[] {1,0,-1,0,-2,2},0)); // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        main.ans.clear();
        JavaUtils.print(main.fourSum(new int[] {2,2,2,2,2},8)); // [[2, 2, 2, 2]]
        main.ans.clear();
        JavaUtils.print(main.fourSum(new int[] {1,-2,-5,-4,-3,3,3,5},-11)); // [[-5, -4, -3, 1]]
        main.ans.clear();
        JavaUtils.print(main.fourSum(new int[] {-1000000000,-1000000000,1000000000,-1000000000,-1000000000},294967296)); // []
        main.ans.clear();
        JavaUtils.print(main.fourSum(new int[] {0,0,0,1000000000,1000000000,1000000000,1000000000},1000000000)); // [[0,0,0,1000000000]]
    }
}
