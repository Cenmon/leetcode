package leetcode;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-10 15:45
 * @Description
 */
public class 最小展台数量LCP66E {

    public int minNumBooths(String[] demand) {
        int[] cnt = new int[26];
        int[] tmp = new int[26];
        for(String s : demand){
            for(int i=0,n=s.length();i<n;i++){
                int idx = s.charAt(i)-'a';
                tmp[idx]++;
                if(tmp[idx] > cnt[idx]){
                    cnt[idx] = tmp[idx];
                }
            }
            Arrays.fill(tmp,0);
        }
        int sum = 0;
        for(int c : cnt) sum+=c;
        return sum;
    }


    public static void main(String[] args) {
        最小展台数量LCP66E main = new 最小展台数量LCP66E();

        /**
         * 给定字符串数组demand[i][j] 表示第 i 天展览时第 j 个展台的类型。
         * 在满足每一天展台需求的基础上，请返回后勤部需要准备的 最小 展台数量。
         */
        System.out.println(main.minNumBooths(new String[]{"acd","bed","accd"})); // 6 abccde展台即可
        System.out.println(main.minNumBooths(new String[]{"abc","ab","ac","b"})); // 3 abc展台即可
    }
}
