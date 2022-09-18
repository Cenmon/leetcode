package 双指针.异地指针.子串匹配;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class 实现strStr28 {

    public int kmp(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int i=0,j=0; // i,j异地指针
        while(i<haystack.length() && j<needle.length()){
            while(j>0 && haystack.charAt(i) != needle.charAt(j) ){
                j = next[j-1];
            }

            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            i++;
        }
        if(j >= needle.length()) return i-j;
        else return -1;
    }

    public int[] getNext(String needle){ // 获取前缀表
        int n = needle.length();
        int[] next = new int[n];
        next[0] = 0;
        for(int i=1,j=0;i<n;i++){ // i快指针,j慢指针
            while(j>0 && needle.charAt(i) != needle.charAt(j)) j = next[j-1];
            if(needle.charAt(i) == needle.charAt(j)) j++; // 另一种情况j=0，i,j指向字符不同
            next[i] = j;
        }
        return next;
    }
}
