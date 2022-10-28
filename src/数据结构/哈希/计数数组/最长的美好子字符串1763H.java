package 数据结构.哈希.计数数组;

/**
 * @Author Cenmo
 * @Date 2022-10-06 11:32
 * @Description
 */
public class 最长的美好子字符串1763H {

    public String longestNiceSubstring(String s) {
        char[] cs = s.toCharArray();
        int start=0,len=0;
        for(int i=1;i<27;i++){
            int[] range = helper(cs,i);
            if(range[1] > len){
                start = range[0];
                len = range[1];
            }
        }
        return s.substring(start,start+len);
    }

    private int[] helper(char[] cs,int t){
        int j=0,type=0,matchType=0;
        int start=0,len=0;
        int[] cnt = new int[128];
        for(int i=0,n=cs.length;i<n;i++){
            while(j<n && type <= t){
                if(cnt[ cs[j] ] == 0 && !existLetter(cnt,cs[j])) type++; // 大小写均不存在
                if(++cnt[ cs[j] ] == 1 && existLetter(cnt,cs[j])) matchType++; // 大小写均存在

                if(type == t && matchType == t && j-i+1 > len){
                    start = i;
                    len = j-i+1;
                }
                j++;
            }

            cnt[ cs[i] ]--;
            if(cnt[cs[i]] == 0 && !existLetter(cnt,cs[i])) type--;
            if(cnt[cs[i]] == 0 && existLetter(cnt,cs[i])) matchType--;
        }
        return new int[]{start,len};
    }

    // private int[] helper(char[] cs,int t){
    //     int i=0,type=0,matchType=0;
    //     int start=0,len=0;
    //     int[] cnt = new int[128];
    //     for(int j=0,n=cs.length;j<n;j++){
    //         if(cnt[ cs[j] ] == 0 && !existLetter(cnt,cs[j])) type++; // 大小写均不存在
    //         if(++cnt[ cs[j] ] == 1 && existLetter(cnt,cs[j])) matchType++; // 大小写均存在
    //         while(type > t){
    //             cnt[ cs[i] ]--;
    //             if(cnt[ cs[i] ] == 0 && !existLetter(cnt,cs[i])) type--;// 大小写均不存在
    //             if(cnt[ cs[i] ] == 0 && existLetter(cnt,cs[i])) matchType--; // 大小写一方存在，一方不存在
    //             i++;
    //         }
    //         if(type == t && matchType == t && j-i+1 > len){
    //             start = i;
    //             len = j-i+1;
    //         }
    //     }
    //     return new int[]{start,len};
    // }

    private boolean existLetter(int[] cnt,char c){
        if('a' <= c && c <= 'z' && cnt[c-32] > 0){ // 小写字母，要求大写字母存在
            return true;
        }else if('A' <= c && c <= 'Z' && cnt[c+32] > 0){ // 大写字母
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        最长的美好子字符串1763H main = new 最长的美好子字符串1763H();

        System.out.println(main);
    }
}
