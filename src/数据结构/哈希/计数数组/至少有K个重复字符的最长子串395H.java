package 数据结构.哈希.计数数组;

/**
 * @Author Cenmo
 * @Date 2022-10-05 23:16
 * @Description
 */
public class 至少有K个重复字符的最长子串395H {

    public int longestSubstring(String s, int k) { // 固定窗口值 + 动态窗口大小
        char[] cs = s.toCharArray();
        int ans = 0;
        for(int i=1;i<27;i++){
            // 窗口大小不定，固定窗口内的字母种类，
            ans = Math.max(ans,helper(cs,i,k));
        }
        return ans;
    }

     private int helper(char[] cs,int t,int k){
         int[] cnt = new int[26];
         int j=0,type=0,matchType=0,ans=0;
         for(int i=0,n=cs.length;i<n;i++){
             while(j<n && type <= t){
                 if(cnt[ cs[j]-'a' ] == 0) type++;
                 if(++cnt[ cs[j]-'a' ] == k) matchType++;

                 if(type == t && matchType == t){
                     ans = Math.max(ans,j-i+1);
                 }
                 j++;
             }
             cnt[ cs[i]-'a' ]--;
             if(cnt[ cs[i]-'a' ] == k-1) matchType--;
             if(cnt[ cs[i]-'a' ] == 0) type--;
         }
         return ans;
     }

//    private int helper(char[] cs,int t,int k){
//        int[] cnt = new int[26];
//        int i=0,type=0,matchType=0,ans=0;
//        for(int j=0,n=cs.length;j<n;j++){
//            if(cnt[ cs[j]-'a' ] == 0) type++;
//            if(++cnt[ cs[j]-'a' ] == k) matchType++; // 入队
//            while(type > t){
//                // 出队
//                // cnt[ cs[i]-'a' ];
//                if(--cnt[ cs[i]-'a' ] == 0) type--;
//                if(cnt[ cs[i]-'a' ] == k-1) matchType--;
//                i++;
//            }
//            if(type == t && matchType == t){
//                ans = Math.max(ans,j-i+1);
//            }
//        }
//        return ans;
//    }


    public static void main(String[] args) {
        至少有K个重复字符的最长子串395H main = new 至少有K个重复字符的最长子串395H();

        /**
         * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，要求该子串中的每一字符出现次数都不少于 k 。
         * 返回这一子串的长度。
         */
        System.out.println(main.longestSubstring("aaabb",3)); // 3
        System.out.println(main.longestSubstring("ababbc",2)); // 5
    }
}
