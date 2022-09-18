package 双指针.窗口指针.滑动窗口;

import java.util.Arrays;

public class 字符子串的排列567 {

    public boolean checkInclusion_cntArray(String s1, String s2) { // 计数数组
        int[] cnt = new int[128];
        int m = s1.length(),n = s2.length();
        for(int i=0;i<m;i++){
            cnt[s1.charAt(i)]++;
        }
        int left = 0,right = 0;
        while(right < n){
            char ch = s2.charAt(right);
            cnt[ch]--;
            // 非s1串字符则右移左指针
            while(cnt[ch] < 0){
                cnt[s2.charAt(left)]++;
                left++;
            }
            if(right - left + 1 == m){
                return true;
            }
            right++;
        }
        return false;
    }

    // 比较s2每个大小为s1.length()的窗口内字符子串的排列是否与s1的排列相同
    public boolean checkInclusion_slideWindow(String s1, String s2) { // 滑动窗口
        int[] cnt1 = new int[128],cnt2 = new int[128];
        int m = s1.length(),n = s2.length();
        // 比较第一个窗口内的排列是否相同
        for(int i=0;i<m;i++){
            cnt1[s1.charAt(i)]++;
            cnt2[s2.charAt(i)]++;
        }
        if(Arrays.equals(cnt1,cnt2)) return true;
        // 比较后续窗口内的排列
        for(int i=m;i<n;i++){
            cnt2[s2.charAt(i)]++; // 划入窗口
            cnt2[s2.charAt(i-m)]--; // 滑出窗口
            if(Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        字符子串的排列567 main = new 字符子串的排列567();

        /**
         * 给定字符串s1,s2，返回s1是否是s2中某子串的排列s
         * 注：子串指相等长度的字符排列相同
         */
        System.out.println(main.checkInclusion_cntArray("ab" , "eidbaooo")); // true
        System.out.println(main.checkInclusion_cntArray("ab" , "eidboaoo")); //false
        System.out.println(main.checkInclusion_cntArray("adc", "dcda")); //true
    }
}
