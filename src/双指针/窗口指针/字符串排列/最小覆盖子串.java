package 双指针.窗口指针.字符串排列;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 * https://www.youtube.com/watch?v=IzynHx-O4lE
 */
public class 最小覆盖子串 {



    public String minWindow (String S, String T) {
        // write code here
        int[] freqt = new int[128];
        int[] maps = new int[128]; // S中的字符出现频率
        int m = S.length(),n=T.length();
        String res = "";
        int minLen = m;

        for(int i=0;i<n;i++)
            freqt[ T.charAt(i) ]++; // 统计字符串T中的字符出现频率
        int left=0,right=0;
        int count=0;
        while( right < m ){
            char r = S.charAt(right);
            if(freqt[ r ] > 0){ //在T出现频率大于0，即字符cs[right]在T串中
                maps[r]++;
                if(maps[ r ] <= freqt[ r ]){ // 滑动窗口内出现的字符频率必须在T的频率下，才会使满足T的字符数增加
                    count++; //滑动窗口中满足T的字符数加一
                }
            }
            if(count == n ){
                /**
                 * 移动left端:left指针指向的字符不属于所求T的字符，即freqt[l]=0，
                 * 或者左右指针指向的字符相同且均是T中字符，即map[l]>freqt[l](因为上面一个if对当前字符频率加一了)
                 * 移动时机：right指向的元素和left指向的元素相同时，表现在先执行上面的map[r]++频率加一，导致map[l]>freqt[l]
                 * 最终结果：maps中各元素出现频率和freqt的相似
                 */
                char l = S.charAt(left);
                while(maps[l] > freqt[l] || freqt[l] == 0){
                    if(maps[l] > freqt[l]){
                        maps[l]--;
                    }
                    left++;
                    l = S.charAt(left);
                }
                if(res.equals("") || right-left+1 < minLen){
                    res = S.substring(left,right+1);
                    minLen = res.length();
                }
            }
            right++;
        }
        return res;
    }

    /**
     * 返回S中包括出现T中所有字符的最小子串长度
     */
    public static void main(String[] args) {
        最小覆盖子串 main = new 最小覆盖子串();

        System.out.println(main.minWindow("XDOYEZODEYXNZ", "XYZ"));//"YXNZ"
        System.out.println(main.minWindow("ADOBECODEBANC", "ABC"));//"BANC"
        System.out.println(main.minWindow("a", "a"));//"a"
        System.out.println(main.minWindow("a", "aa"));//""
    }
}
