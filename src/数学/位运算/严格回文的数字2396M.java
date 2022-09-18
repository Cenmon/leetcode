package 数学.位运算;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-09-11 20:12
 * @Description
 */
public class 严格回文的数字2396M {

    /**
     * 脑筋急转弯：由于计算十进制转2到n-2进制，一个数n(n>2)转n-2进制，最终都是12( n = 1*(n-2)+2 ),故都不是严格回文串
     * 模拟思想：计算n的2到n-2进制表示，观察是否为回文
     */
    public boolean isStrictlyPalindromic(int n) {
        return false;

        // for(int i=2;i<=n-2;i++){
        //     if(!isPalindrome(n,i)){
        //         return false;
        //     }
        // }
        // return true;
    }

    private boolean isPalindrome(int n,int k){
        List<Integer> arr = new ArrayList<>();
        while(n > 0){
            arr.add(n % k);
            n = n / k;
        }
        int left=0,right=arr.size()-1;
        while(left < right && arr.get(left) == arr.get(right)){
            left++;
            right--;
        }
        return left>=right;
    }


    public static void main(String[] args) {
        严格回文的数字2396M main = new 严格回文的数字2396M();

        /**
         * 给定十进制数字n，判断其2到n-2进制的表示串是否为回文
         * 如
         * 在 2 进制下：9 = 1001 ，是回文的。
         * 在 3 进制下：9 = 100 ，不是回文的。
         * 所以，9 不是严格回文数字，我们返回 false 。
         * 注意在 4, 5, 6 和 7 进制下，n = 9 都不是回文的。
         */
        System.out.println(main.isStrictlyPalindromic(9));// false
        System.out.println(main.isStrictlyPalindromic(4)); // false
    }
}
