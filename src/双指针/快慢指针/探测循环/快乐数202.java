package 双指针.快慢指针.探测循环;

/**
 * @author Cenmo
 * @Date 2022-07-03 2022-07-03
 */
public class 快乐数202 {

    public boolean isHappy(int n) { // 快慢指针探测环
        long slow = n,fast = n;
        while(fast != 1 && next(fast) != 1){
            slow = next(slow);
            fast = next(next(fast));
            if( slow == fast ) return false;
        }
        return true;
    }

    public long next(long num){
        long sum = 0;
        while(num != 0){
            sum += Math.pow(num % 10,2);
            num = num / 10;
        }
        return sum;
    }

    /**
     * 任何快乐数最终会进入4-16-37-58-89-145-42-20-4的循环
     * 因此只需要设置一个hashset将这些纸存储起来，如果next(n)等于该值中某一个，则是快乐数，若最终等于1，则不是快乐数
     * @param args
     */

    public static void main(String[] args) {
        快乐数202 main = new 快乐数202();
        /**
         * 个位，十位，百位...的平方和，递归最终是否能等于1，等于1则为快乐数，反之false
         * 1^2 + 9^2 = 82
         * 8^2 + 2^2 = 68
         * ......
         */
        System.out.println(main.isHappy(19)); // true
    }
}
