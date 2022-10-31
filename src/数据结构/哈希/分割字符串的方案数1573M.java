package 数据结构.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-30 11:04
 * @Description
 */
public class 分割字符串的方案数1573M {

    public int numWays(String s) {
        Map<Integer,Integer> map = new HashMap<>(); // oneCount - i
        int oneCount=0,n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1') {
                oneCount++;
                map.put(oneCount,i);
            }
        }
        if(oneCount == 0) return (int)((long)(n-1)*(n-2)/2%1000000007);
        if(oneCount % 3 != 0) return 0;
        long leftZero = map.get(oneCount/3+1) - map.get(oneCount/3); // 实际为中间段左边零个数加一
        long rightZero = map.get(2*oneCount/3+1) - map.get(2*oneCount/3);
        // int left=0,right=n-1;
        // int leftOne=0,rightOne=0;
        // while(leftOne < one/3){
        //     if(s.charAt(left++) == '1'){
        //         leftOne++;
        //     }
        // }
        // while(rightOne < one/3){
        //     if(s.charAt(right--) == '1'){
        //         rightOne++;
        //     }
        // }
        // // System.out.println("left = " + left + " , right = " + right);
        // long leftZero=0,rightZero=0;
        // while(left<right && s.charAt(left) == '0') {leftZero++;left++;}
        // while(left<right && s.charAt(right) == '0') {rightZero++;right--;}
        // // System.out.println("leftZero = " + leftZero + " , rightZero = " + rightZero);
        return (int)(leftZero * rightZero % 1000000007);
    }


    public static void main(String[] args) {
        分割字符串的方案数1573M main = new 分割字符串的方案数1573M();

        /**
         * 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个
         * 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
         *
         * 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
         *
         * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
         */

        System.out.println(main.numWays("10101")); // 4
        System.out.println(main.numWays("1001")); // 0
        System.out.println(main.numWays("0000")); // 3
        System.out.println(main.numWays("100100010100110")); // 12
    }
}
