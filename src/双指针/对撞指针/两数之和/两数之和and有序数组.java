package 双指针.对撞指针.两数之和;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-07-01 2022-07-01
 */
public class 两数之和and有序数组 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left=0,right=numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if( sum == target){
                ans[0] = left+1;
                ans[1] = right+1;
                break;
            }else if( sum < target ){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        两数之和and有序数组 main = new 两数之和and有序数组();

        ArrayUtils.print(main.twoSum(new int[]{2,7,11,15},9)); //1,2
        ArrayUtils.print(main.twoSum(new int[]{2,3,4},6)); //1,3
        ArrayUtils.print(main.twoSum(new int[]{-1,0},-1)); // 1,2
        ArrayUtils.print(main.twoSum(new int[]{0,0,3,4},0)); // 1,2
    }
}
