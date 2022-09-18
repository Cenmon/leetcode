package 双指针.异地指针.判断子序列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 字典里的最长子序列524M {

    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for(String t : dictionary){
            if((t.length() > ans.length() || t.length() == ans.length() && t.compareTo(ans)<0) && isSubsequence(t,s)){
                ans = t;
            }
        }
        return ans;
    }

    private boolean isSubsequence(String s , String t){
        int m = s.length(),n = t.length(),i = 0, j = 0;
        while( i < m && j < n ){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==m;
    }

    public String findLongestWord2(String s, List<String> dictionary){
        Collections.sort(dictionary, new Comparator<String>() {
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length(); // 降序1,2
                } else {
                    return word2.compareTo(word1); // 升序2,1
                }
            }
        });
        for(String t : dictionary){
            if(isSubsequence(t,s)) return t;
        }
        return "";
    }


    public static void main(String[] args) {
        字典里的最长子序列524M main = new 字典里的最长子序列524M();

        /**
         * 给定字符串s和字符串字典dictionary，返回字典dictionary中关于s的长度最长，字符串最小的子序列
         */
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("appla");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(main.findLongestWord("abpcplea",dictionary)); // apple

        dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        System.out.println(main.findLongestWord("abpcplea",dictionary)); // a
    }
}
