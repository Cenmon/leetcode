package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-19 11:46
 * @Description
 */
public class 使结果不超过阈值的最小除数1283M {

    public int smallestDivisor(int[] nums, int threshold) {
        // 除数为1时商的和最大为整个数组和，除数为max(nums)时商的和最小为nums.length
        int left=1,right=nums[0];
        for(int num : nums) if(num > right) right=num;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 数组元素除mid的商小于等于threshold
            if(SmallAndEqualThreshold(nums,threshold,mid)){
                right = mid - 1;
                // System.out.println(mid + " , true");
            }else{
                left = mid + 1;
                // System.out.println(mid + " , false");
            }
        }
        return left;
    }

    private boolean SmallAndEqualThreshold(int[] nums,int threshold,int div){
        int sum = 0;
        for(int num : nums){
            // sum += (int)Math.ceil(num / div);
            sum += (num + div - 1) / div;
        }
        return sum <= threshold;
    }


    public static void main(String[] args) {
        使结果不超过阈值的最小除数1283M main = new 使结果不超过阈值的最小除数1283M();

        /**
         * 给你一个整数数组 nums 和一个正整数 threshold，
         * 你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
         * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
         * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
         * 题目保证一定有解。
         */
        System.out.println(main.smallestDivisor(new int[]{1,2,5,9},6)); // 5
        System.out.println(main.smallestDivisor(new int[]{2,3,5,7,11},11)); // 3
        System.out.println(main.smallestDivisor(new int[]{44,22,33,11,1},5)); // 44
        System.out.println(main.smallestDivisor(new int[]{19},5)); // 4
    }
}
