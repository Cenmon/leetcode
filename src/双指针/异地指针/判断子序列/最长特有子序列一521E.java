package 双指针.异地指针.判断子序列;

public class 最长特有子序列一521E {

    /**
     * 若字符串s有特有字母a，则整个字符串s即为特有子序列
     * 若一方A是另一方B的子序列，则最长独有子序列为B的长度(A独有长度为0)
     * 若两方互为对方的子序列(相等),则返回-1
     */
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        return Math.max(a.length(),b.length());
    }


    public static void main(String[] args) {
        最长特有子序列一521E main = new 最长特有子序列一521E();

        /**
         * 给出两个字符串，返回两字符串最长子序列长度，且最长子序列为某个字符串独有
         */
        System.out.println(main.findLUSlength("aba", "cdc")); // 3
        System.out.println(main.findLUSlength("aaa",  "bbb")); // 3
        System.out.println(main.findLUSlength("aaa",  "aaa")); // -1
    }
}
