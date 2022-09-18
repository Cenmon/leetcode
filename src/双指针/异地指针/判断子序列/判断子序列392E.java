package 双指针.异地指针.判断子序列;

import java.util.ArrayList;

/**
 * @author Cenmo
 * @Date 2022-07-01 2022-07-01
 */
public class 判断子序列392E {

    /**
     * 判断s是否是t的子序列
     */
    public boolean isSubsequence(String s, String t) {
        int m=s.length(),n=t.length();
        if(m > n) return false;
        int i=0,j=0;
        while(i<m && j<n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == m;
    }

    public static void main(String[] args) {
        判断子序列392E main = new 判断子序列392E();

        System.out.println(main.isSubsequence("abc",  "ahbgdc")); // true
        System.out.println(main.isSubsequence("axc", "ahbgdc")); // false

        System.out.println("aeiouAEIOU".indexOf('b'));
        ArrayList<Integer> list = new ArrayList<>();
        list.toArray(new Integer[1]);
    }
}
