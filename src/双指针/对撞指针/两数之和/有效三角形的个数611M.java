package 双指针.对撞指针.两数之和;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-09 2022-07-09
 */
public class 有效三角形的个数611M {

    private int ANS = 0;
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        // 确定最长边a,此时有另外两边a>b,a>c -> a+c>b,a+b>c,b-a<0<c,c-a<0<b
        // 因为b>0,c>0,a>b,a>c，所以a>|b-c|
        // 当b+c>a时，有a-c<b,a-b<c
        for(int i=nums.length-1;i>0;i--){
            twoSum(nums,0,i-1,nums[i]);
        }
        return ANS;
    }

    private void twoSum(int[] nums,int left,int right,int third){
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum > third){
                ANS += right - left;
                right--;
            }else{
                left++;
            }
        }
    }

    public static void main(String[] args) {
        有效三角形的个数611M main = new 有效三角形的个数611M();

        System.out.println(main.triangleNumber(new int[]{2,2,3,4})); // 3
        System.out.println(main.triangleNumber(new int[]{4,2,3,4})); // 4
    }
}
