package 双指针.窗口指针.滑动窗口.固定窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-10-27 21:15
 * @Description
 */
public class 找到字符串中所有字母异位词438M {

    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[26];
        int[] track = new int[26];
        int n=s.length(),m=p.length();
        int matchType=0,type = 0;
        for(int i=0;i<m;i++){
            if(++cnt[ p.charAt(i)-'a' ] == 1) type++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int j=0;j<n;j++){
            // matchType++ : 入窗口后词频等于cnt
            if(++track[ s.charAt(j)-'a' ]==cnt[ s.charAt(j)-'a' ])
                matchType++; // 入队cnt[s.charAt(j)-'a']>0 &&

            // matchType-- : 出窗口后词频等于cnt-1
            if(j >= m){// 固定窗口出队
                if(--track[s.charAt(j-m)-'a']==cnt[s.charAt(j-m)-'a']-1)
                    matchType--;
            }
            // 必须出完队后再判断，若未出完队，此时队内元素大于窗口大小
            if(matchType == type) ans.add(j-m+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        找到字符串中所有字母异位词438M main = new 找到字符串中所有字母异位词438M();

        /**
         * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
         *
         * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
         */
        System.out.println(main.findAnagrams("cbaebabacd","abc"));// [0, 6]
        System.out.println(main.findAnagrams("abab","ab"));// [0, 1, 2]
        System.out.println(main.findAnagrams("abaacbabc","abc"));//[3, 4, 6]
    }
}
