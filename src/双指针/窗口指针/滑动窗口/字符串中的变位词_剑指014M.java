package 双指针.窗口指针.滑动窗口;

/**
 * @Author Cenmo
 * @Date 2022-08-27 22:22
 * @Description 滑动窗口：静态窗口
 */
public class 字符串中的变位词_剑指014M {

    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[] cnt = new int[128];
        for(int i=0;i<m;i++) cnt[s1.charAt(i)]++;

        int count=0; // 满足排列的字母个数
        for(int left=0,right=0;right<n;right++){
            if(cnt[s2.charAt(right)] > 0){
                count++;
            }
            cnt[s2.charAt(right)]--;

            left = right-m;
            if(left>=0){
                if(cnt[s2.charAt(left)] >= 0)
                    count--;
                cnt[s2.charAt(left)]++;
            }
            if(count == m) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        字符串中的变位词_剑指014M main = new 字符串中的变位词_剑指014M();

        /**
         * 给定字符串s1,s2，判断s2中是否存在s1的变位词 (变位词即字符串的某个排列）
         */
        System.out.println(main.checkInclusion("ab","eidbaooo")); // ture
        System.out.println(main.checkInclusion("ab","eidboaoo")); // false
    }
}
