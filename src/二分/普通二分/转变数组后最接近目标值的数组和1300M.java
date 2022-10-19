package 二分.普通二分;

/**
 * @Author Cenmo
 * @Date 2022-10-19 17:06
 * @Description 一般用于求值和值的关系
 */
public class 转变数组后最接近目标值的数组和1300M {

    public int findBestValue(int[] arr, int target) {
        int max = arr[0];
        long sum = 0;
        for(int num : arr){
            if(num > max) max = num;
            sum += num;
        }
        if(sum <= target) return max; //整个数组和小于target,无法增大,只能返回最大值

        // 最小变化值为1，最大变化值为max,若大于max,则说明整个数组和小于target，无法再增大
        int left=1,right=max;
        while(left <= right){
            int mid = left + (right-left)/2;

            sum = getSum(arr,mid);
            // 变化后的值是否和target相等
            if(sum == target){
                return mid;
            }else if(sum > target){ // 减小sum：通过减小mid，所有大于mid的值均变为mid
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if( Math.abs(target-getSum(arr,left)) < Math.abs(target-getSum(arr,right)) ){
            return left;
        }else{ // 差值大于等于时，right指向值更小
            return right;
        }
    }
    // 求大于value的值变为value后的数组和
    private long getSum(int[] arr,int value){
        long sum = 0;
        for(int num : arr){
            if(num > value) sum += value;
            else sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        转变数组后最接近目标值的数组和1300M main = new 转变数组后最接近目标值的数组和1300M();

        /**
         *给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
         * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
         * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
         * 请注意，答案不一定是 arr 中的数字。
         */
        System.out.println(main.findBestValue(new int[]{4,9,3},10));//3
        System.out.println(main.findBestValue(new int[]{2,3,5},10));//5
        System.out.println(main.findBestValue(new int[]{60864,25176,27249,21296,20204},56803));//11361
        System.out.println(main.findBestValue(new int[]{2,3,5},11));//5
    }
}
