package 双指针.对撞指针.两数之和;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class 最接近的三数之和16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = nums[0]+nums[1]+nums[2]; // long值避免数值越界
//        int ans = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            if(nums[i] > target && nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1,right = nums.length-1;
            while(left < right){
                long sum = nums[i] + nums[left] + nums[right];
                if( Math.abs(sum - target) <= Math.abs(ans - target) ){
                    ans = sum;
                }

                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    break;
                }
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        最接近的三数之和16 main = new 最接近的三数之和16();

        System.out.println(main.threeSumClosest(new int[] {-1,2,1,-4},1)); // 2
        System.out.println(main.threeSumClosest(new int[] {0,0,0},1)); // 0
        System.out.println(main.threeSumClosest(new int[] {1,1,-1,-1,3},-1)); // -1
        System.out.println(main.threeSumClosest(new int[] {1,1,1,1},0)); // 3
    }
}
