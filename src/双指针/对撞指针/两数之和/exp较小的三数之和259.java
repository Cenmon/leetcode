package 双指针.对撞指针.两数之和;

/**
 * @author Cenmo
 * @Date 2022-07-09 2022-07-09
 */
public class exp较小的三数之和259 {

    private int ANS = 0;
    public int SmallerThreeSum(int[] nums,int target){
        int n = nums.length;
        for(int i=0;i<n;i++){
            twoSum(nums,i+1,n-1,target-nums[i]);
        }
        return ANS;
    }

    public void twoSum(int[] nums,int left,int right,int target){ // 两数之和小于特定值的情况总数
        while(left < right){
            if( nums[left] + nums[right] < target ){
                ANS += right - left;// 当前sum<target,sum变小时也必定小于target，故总数=right-left
                left++;
            }else{
                right--;
            }
        }
    }

    public static void main(String[] args) {
        exp较小的三数之和259 main = new exp较小的三数之和259();

        /**
         * 三数之和小于特定值的情况种数
         */
        System.out.println(main.SmallerThreeSum(new int[]{-2,0,1,3},2)); // 2 [[-2,0,1],[-2,0,3]]
    }
}
