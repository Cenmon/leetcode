package 双指针.快慢指针.交叉重排;

public class 交叉合并字符串1768E {

    public String mergeAlternately2(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int i=0,j=0,m=word1.length(),n=word2.length();
        while(i<m || j<n){
            if(i<m){
                sb.append(word1.charAt(i++));
            }
            if(j<n){
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        char[] ans = new char[m+n];
        for(int i=0,idx=0 ; i<m || i<n ; i++){
            if(i<m){
                ans[idx++] = word1.charAt(i);
            }
            if(i<n){
                ans[idx++] = word2.charAt(i);
            }
        }
        return new String(ans);
    }


    public static void main(String[] args) {
        交叉合并字符串1768E main = new 交叉合并字符串1768E();

        System.out.println(main.mergeAlternately("abc","pqr")); //apbqcr
        System.out.println(main.mergeAlternately("ab", "pqrs")); //apbqrs
        System.out.println(main.mergeAlternately("abcd","pq")); //apbqcd
    }
}
