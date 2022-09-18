package 双指针.对撞指针.翻转数组;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 反转字符串 {

    public char[] reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        return s;
    }

    public static void main(String[] args) {
        反转字符串 main = new 反转字符串();

        ArrayUtils.print(main.reverseString(new char[]{'h','e','l','l','o'})); // o,l,l,e,h
        ArrayUtils.print(main.reverseString(new char[]{'H','a','n','n','a','h'})); // h,a,n,n,a,H

    }
}
