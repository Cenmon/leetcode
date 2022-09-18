package 动态规划.自上而下分解.进阶;

/**
 * @author Cenmo
 * @Date 2022-03-25 2022-03-25
 */
public class 打家劫舍二 {

    public int rob (int[] nums) {
        // write code here
        int n= nums.length;
        if(n == 1) return nums[n];
        if(n == 2) return Math.max(nums[0],nums[1]);
        return Math.max(robBetween(nums,0,n-2),robBetween(nums,1,n-1));
    }

    public int robBetween(int[] nums,int start,int end){
        int first=nums[start],second=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int tmp = second;
            second = Math.max(first+nums[i],second);
            first = tmp;
        }
        return second;
    }


    /**
     * 相邻不能偷，首尾不能一起偷，即房子组成一个环
     */
    public static void main(String[] args) {
        打家劫舍二 main = new 打家劫舍二();

        System.out.println(main.rob(new int[]{1,2,3,4})); // 2+4=6
        System.out.println(main.rob(new int[]{1,3,6}));  // 6
    }
}
