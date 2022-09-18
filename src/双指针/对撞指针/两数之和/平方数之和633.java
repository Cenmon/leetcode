package 双指针.对撞指针.两数之和;

/**
 * @author Cenmo
 * @Date 2022-07-09 2022-07-09
 */
public class 平方数之和633 {

    public boolean judgeSquareSum(int c) { // 平方和为特定值
        long left = 0,right = (long)Math.sqrt(c); // 注意左右指针也可能越界
        long sum = 0;
        while(left <= right){
            sum = left * left + right * right;
            if(sum == c){
                return true;
            }else if(sum > c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        平方数之和633 main = new 平方数之和633();

        /**
         * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c
         */
        System.out.println(main.judgeSquareSum(5)); // true
        System.out.println(main.judgeSquareSum(3)); // false
        System.out.println(main.judgeSquareSum(4)); // true
        System.out.println(main.judgeSquareSum(8)); // true
        System.out.println(main.judgeSquareSum(2147483600)); // true

    }
}
