package 数据结构.字符串;

/**
 * @author Cenmo
 * @Date 2022-03-07 2022-03-07
 */
public class KMP算法 {

    /**
    * 计算模板串S在文本串T中出现了多少次
     * 印度三个版本：https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public int kmp (String S, String T) {
        // write code here
        char[] ct = T.toCharArray();
        char[] cs = S.toCharArray();
        int m=ct.length,n=cs.length;

        int i=0,j=0;
        int num=0;
        int[] next = get_next(cs);

        while( i<m ){
            if(j==-1 || ct[i] == cs[j]){
                i++;j++;
            }else{ //不匹配时
                j = next[j];
            }

            if(j == n){
                num++;
                i--;
                j = next[j-1];
            }
        }
        return num;
    }

    private int[] get_next(char[] cs) {
        int[] next = new int[cs.length];
        int i=1,len=0;
        next[0] = -1;
        next[1] = 0;
        while( i < cs.length-1 ){
            if(len == -1 || cs[i] == cs[len] ){ //i遍历数组，len表示i位置前的字符串中 小于串长的最长公共前缀和后缀长度，在数组中指向前缀尾
                // len指公共前后缀长度，但next记录下一次j调转的位置，故next[i+1]=len+1
                next[i+1] = len+1; //i和len位置字符相等，则确定next[i+1]位置，即next[i+1]=next[i]+1
                i++;len++;
            }else{ // i和len位置处不相等
                len = next[len]; //len跳到len左侧的公共前后缀处
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP算法 main = new KMP算法();

        int res = main.kmp("ababab", "abababab");
//        int res = main.kmp("abab","abacabab");
//        int[] next = main.get_next(new String("abaabcaba").toCharArray());

        System.out.println("res = " + res);
    }

}
