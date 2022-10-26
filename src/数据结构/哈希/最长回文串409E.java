package 数据结构.哈希;

/**
 * @Author Cenmo
 * @Date 2022-10-26 20:50
 * @Description
 */
public class 最长回文串409E {

    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for(int i=0,n=s.length();i<n;i++){
            cnt[s.charAt(i)]++;
        }
        int ans = 0;
        boolean hasOne = false;
        for(int c : cnt){
            if(c % 2 == 0){
                ans += c; // 偶数个，放两端
            }else{
                ans += c-1; //奇数个减一即偶数个，放两端
                hasOne = true;// 放最中间
            }
        }
        if(hasOne) ans++;
        return ans;
    }


    public static void main(String[] args) {
        最长回文串409E main = new 最长回文串409E();

        /**
         * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
         *
         * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串
         */
        System.out.println(main.longestPalindrome("abccccdd")); // 7
        System.out.println(main.longestPalindrome("a")); // 1
        System.out.println(main.longestPalindrome("ccc")); // 3
    }
}
