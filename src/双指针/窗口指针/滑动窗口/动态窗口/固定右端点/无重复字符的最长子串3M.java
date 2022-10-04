package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-03 22:11
 * @Description 固定右端点
 */
public class 无重复字符的最长子串3M {

    public int lengthOfLongestSubstring(String s) {
        int[] idx = new int[256];
        Arrays.fill(idx,-1);
        int ans=0;
        for(int i=0,j=0,n=s.length();j<n;j++){
            char c = s.charAt(j);
            if(idx[c] >= 0){
                i = Math.max(i,idx[c]+1);
            }
            idx[c] = j;
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        无重复字符的最长子串3M main = new 无重复字符的最长子串3M();

        /**
         * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
         */
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(main.lengthOfLongestSubstring("bbbbb"));
        System.out.println(main.lengthOfLongestSubstring("pwwkew"));
    }
}
