package 二分.最左二分;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 寻找重复数287M {

    public int findDuplicate3(int[] nums) { // hash
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

    public int findDuplicate(int[] nums) { // 快慢指针寻找环入口
        int n=nums.length;
        int slow=0,fast=0;
        while(fast < n && nums[fast] < n){
            slow = nums[slow];
            fast = nums[ nums[fast] ];
            if(slow == fast){
                fast = 0;
                while(slow != fast){ // 找环入口
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
        return nums[slow];
    }

    public int findDuplicate2(int[] nums) { //二分
        int left=1,right=nums.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 计算小于等于mid的个数
            int count = 0;
            for(int num : nums){
                if(num <= mid) count++;
            }
            if(count > mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        寻找重复数287M main = new 寻找重复数287M();
        /**
         * n+1个范围在[1,n]里的数，必有至少一个是重复值，找出这个重复的值
         */
        System.out.println(main.findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(main.findDuplicate(new int[]{3,1,3,4,2})); // 3
    }
}
