package 贪心;

/**
 * @Author Cenmo
 * @Date 2022-09-12 12:25
 * @Description
 */
public class 跳跃游戏55M {

    public boolean canJump(int[] nums) {
        int n=nums.length,far=0;
        for(int i=0;i<n-1;i++){
            if(far < i) return false;
            far = Math.max(far,i+nums[i]);
        }
        return far>=n-1;
    }


    public static void main(String[] args) {
        跳跃游戏55M main = new 跳跃游戏55M();

        /**
         * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 判断你是否能够到达最后一个下标。
         */
        System.out.println(main.canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(main.canJump(new int[]{3,2,1,0,4})); // false
    }
}
