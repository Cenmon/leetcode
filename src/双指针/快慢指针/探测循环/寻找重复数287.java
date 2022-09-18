package 双指针.快慢指针.探测循环;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 寻找重复数287 {

    public int findDuplicate2(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]  < 0) {
                return index+1;
            }else{
                nums[ index ] *= -1;
            }
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int slow=0,fast=0;
        while(fast < n && nums[fast] < n){
            slow = nums[slow];
            fast = nums[ nums[fast] ];
            if(slow == fast){
                fast = 0;
                while(slow != fast){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
        return nums[slow];
    }

    public static void main(String[] args) {
        寻找重复数287 main = new 寻找重复数287();
        /**
         * n+1个范围在[1,n]里的数，必有至少一个是重复值，找出这个重复的值
         */
        System.out.println(main.findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(main.findDuplicate(new int[]{3,1,3,4,2})); // 3
    }
}
