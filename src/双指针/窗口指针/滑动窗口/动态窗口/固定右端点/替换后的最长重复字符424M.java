package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

/**
 * @Author Cenmo
 * @Date 2022-10-03 17:54
 * @Description 固定右边界
 */
public class 替换后的最长重复字符424M {

    public int characterReplacement(String s, int k) { // 固定右边界
        char[] cs = s.toCharArray();
        int[] cnt = new int[128];
        int i=0,n=cs.length,ans=0;
        for(int j=0;j<n;j++){
            cnt[ cs[j] ]++;
            // j-i+1 - maxRepeat(cnt)即需要替换的字符数
            while(j-i+1 - maxRepeat(cnt) > k){
                cnt[ cs[i] ]--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }


    public int characterReplacement2(String s, int k) { // 固定左边界
        char[] cs = s.toCharArray();
        int j=0,n=cs.length,ans=0;
        int[] cnt = new int[26];
        for(int i=0;i<n;i++){
//            while(j<n && j-i-maxRepeat(cnt) <= k){
                // 该类代码右端点不加入窗口，该题中满足不需要替换的字符个数小于等于k即可将右端点加入窗口，显然这是错的
            while(j<n && canAdd(cs,cnt,j,j-i+1,k)){
                j++;
            }
            ans = Math.max(ans,j-i);
            if(j >= n) break;
            cnt[ cs[i]-'A' ]--;
        }
        return ans;
    }

    private boolean canAdd(char[] cs,int[] cnt, int j, int total,int k) {
        cnt[ cs[j]-'A' ]++;
        if(total - maxRepeat(cnt) <= k) {
            return true;
        }else{
            cnt[ cs[j]-'A' ]--;
            return false;
        }

    }

    private int maxRepeat(int[] cnt){
        int max = cnt[0];
        for(int c : cnt)
            if(c > max)
                max = c;
        return max;
    }


    // 暴力解法是i,j指针遍历所有子串[i,j],如果[i,j]里需要替换的字符数小于k则该子串满足所求条件
    public static void main(String[] args) {
        替换后的最长重复字符424M main = new 替换后的最长重复字符424M();

        /**
         * 给定字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
         *
         * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
         */
        System.out.println(main.characterReplacement2("ABAB",2)); // 4
        System.out.println(main.characterReplacement2("AABABBA",1)); // 4
    }
}
