package 双指针.异地指针.下一个字典序;

public class 构造字典序最大的合并字符串1754M {

//    @Cenmo:字典序问题：合并字符串的常用模板
    public String largestMerge(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        char[] merge = new char[m+n];
        int i=0,j=0,idx=0;
        while(i<m && j<n){
            if( word1.substring(i).compareTo(word2.substring(j))>=0 ){
                merge[idx++] = word1.charAt(i++);
            }else {
                merge[idx++] = word2.charAt(j++);
            }
        }
        while(i<m) merge[idx++] = word1.charAt(i++);
        while(j<n) merge[idx++] = word2.charAt(j++);
        return new String(merge);
    }

    public static void main(String[] args) {
        构造字典序最大的合并字符串1754M main = new 构造字典序最大的合并字符串1754M();

        /**
         * 给定两个字符串word1,word2，按最大字典序合并两个字符串，并返回
         */
        System.out.println(main.largestMerge("cabaa","bcaaa")); // "cbcabaaaaa"
        System.out.println(main.largestMerge("abcabc","abdcaba")); // "abdcabcabcaba"
    }
}
