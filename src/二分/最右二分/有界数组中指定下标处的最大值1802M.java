package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-21 14:54
 * @Description
 */
public class 有界数组中指定下标处的最大值1802M {

    public int maxValue(int n, int index, int maxSum) {
        //nums[index]最小为1，最大为maxSum
        long left=1,right=maxSum;
        while(left <= right){
            long value = left+(right-left)/2;
            // 是否存在nums[index]=mid的数组
            long leftMin,rightMin;
            long num = index+1; //包括idx的idx左边元素个数
            if(num > value) leftMin=(num-value)+(1+value)*value/2;
            else leftMin=(value-num+1+value)*num/2;

            num = n-index;//包括idx的idx右边元素个数
            if(num > value) rightMin=(num-value)+(1+value)*value/2;
            else rightMin=(value-num+1+value)*num/2;
            long min = leftMin+rightMin-value,max=value*n;
            // System.out.println("leftMin = " + leftMin + " , rightMin = " + rightMin);
            // System.out.println("value = " + value + " , min = " + min + " , max = " + max);

            if(maxSum < min){
                right = value - 1;
            }else if(maxSum > max){
                left = value + 1;
            }else{
                left = value + 1; // 存在则探测更大值
            }
        }
        return (int)right;
    }


    public static void main(String[] args) {
        有界数组中指定下标处的最大值1802M main = new 有界数组中指定下标处的最大值1802M();

        /**
         * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
         *
         * nums.length == n
         * nums[i] 是 正整数 ，其中 0 <= i < n
         * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
         * nums 中所有元素之和不超过 maxSum
         * nums[index] 的值被 最大化
         * 返回你所构造的数组中的 nums[index] 。
         */
        System.out.println(main.maxValue(4,2,6));// 2
        System.out.println(main.maxValue(3,2,18)); // 7
        System.out.println(main.maxValue(6,1,10));//3
        System.out.println(main.maxValue(3,0,815094800));//271698267
    }
}
