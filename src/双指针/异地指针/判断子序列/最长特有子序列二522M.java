package 双指针.异地指针.判断子序列;

public class 最长特有子序列二522M { // Longest UnCommon SubSequence

    /**
     * 独有子序列所在字符串也是独有子序列，
     * 即某字符串若是其他字符串的子序列，则该字符的独有子序列为0
     * 反之字符串不是其他字符串的子序列，则该字符串最长独有子序列长度为其本身长度
     */
    public int findLUSlength(String[] strs) {
        int n = strs.length,ans = -1;
        boolean isUnCommon;
        for(int i=0;i<n;i++){
            isUnCommon = true; // 独有
            for(int j=0;j<n;j++){
                if(i != j && isSubsequence(strs[i],strs[j])){
                    isUnCommon = false;
                    break;
                }
            }
            if(isUnCommon){
                ans = Math.max(ans,strs[i].length());
            }
        }
        return ans;
    }

    /**
     * 判断s是否是t的子序列
     */
    public boolean isSubsequence(String s,String t){
        int m=s.length(),n=t.length();
        if(m > n) return false;
        int i=0,j=0;
        while(i<m && j<n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==m;
    }

    public static void main(String[] args) {
        最长特有子序列二522M main = new 最长特有子序列二522M();

        /**
         * 给出若干字符串，返回若干字符串最长子序列长度，且最长子序列为某个字符串独有
         */
        System.out.println(main.findLUSlength(new String[]{"aba","cdc","eae"})); // 3
        System.out.println(main.findLUSlength(new String[]{"aaa","aaa","aa"})); // -1
    }
}
