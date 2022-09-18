package 双指针.异地指针.判断子序列;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-08-25 19:20
 * @Description 子序列判定字符串链，且加上动态规划得到最长
 */
public class 最长字符串链1048M {

    public int longestStrChain(String[] words) {
        Arrays.sort(words,(o1, o2)->o1.length()-o2.length());
        int ans=0,n=words.length;
        int[] dp = new int[n];
        // Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            int len = words[i].length();
            for(int j=i-1;j>=0;j--){
                if(len-words[j].length()>1) break;
                else if(len-words[j].length()==1 && isSubsequence(words[j],words[i])){
                    // 长度差1，且是子序列
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }//注：当words[i]="m",words[j]="m"时，两者长度相同且互为子序列
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans+1;
    }

    private boolean isSubsequence(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int i=0,j=0;
        while(i<m && j<n){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i>=m;
    }


    public static void main(String[] args) {
        最长字符串链1048M main = new 最长字符串链1048M();

        /**
         * 给出字符串数组words，若字符串s1某个位置加一个字母得到s2,则s1->s2构成词链，
         * 如"abc"是"abac"的前身，而"cba"不是"bcad"的前身
         * 返回words中最长词链长度
         */
        System.out.println(main);
    }
}
