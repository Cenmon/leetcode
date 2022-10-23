package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-23 17:10
 * @Description
 */
public class 每个小孩最多能分到多少糖果2226M {

    public int maximumCandies(int[] candies, long k) {
        // 可以拿走的糖果数目最少为0，最大为sum/k
        long left=1,right=0;
        for(int candy : candies){
            right += candy;
        }
        right /= k;
        while(left <= right){
            long mid = left +(right-left)/2;
            // 能否使每个小孩拿走mid个糖果
            if(canGetMidCandies(candies,k,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (int)right;
    }

    private boolean canGetMidCandies(int[] candies,long k,long num){
        long count = 0; // 每个小孩分num个，可以分多少个小孩
        for(int candy : candies){
            count += candy/num;
        }
        return count >= k;
    }


    public static void main(String[] args) {
        每个小孩最多能分到多少糖果2226M main = new 每个小孩最多能分到多少糖果2226M();

        /**
         * 给定糖果数组candies以及小孩数量k，candies[i]表示第i堆糖果的数量
         * 每堆糖果可以拆分为若干子堆，但母堆和子堆都不能合并
         * 一个小孩只能拿一堆糖果，返回每个小孩最多能分到多少糖果
         */
        System.out.println(main.maximumCandies(new int[]{5,8,6},3)); // 5
         System.out.println(main.maximumCandies(new int[]{2,5},11));// 0
        System.out.println(main.maximumCandies(new int[]{4,7,5},4)); // 3
    }
}
