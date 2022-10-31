package 数据结构.哈希.数组作map;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-10-29 16:42
 * @Description
 */
public class 查找和替换模式890M {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String p = encode(pattern);
        // System.out.println(p);

        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(p.equals(encode(word))){
                ans.add(word);
            }
        }
        return ans;
    }

    private String encode(String s){ // 将字符串全部映射成数字，相同字母则相同数字
        int num = 10; // 从10开始，共26个字母，不会出现编码错误
        int[] map = new int[26];
        StringBuffer sb = new StringBuffer();
        for(int i=0,n=s.length();i<n;i++){
            if(map[s.charAt(i)-'a'] > 0){
                sb.append(map[s.charAt(i)-'a']);
            }else{
                map[s.charAt(i)-'a'] = num;
                sb.append(num);
                num++;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        查找和替换模式890M main = new 查找和替换模式890M();

        /**
         * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
         *
         * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
         *
         * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
         *
         * 返回 words 中与给定模式匹配的单词列表。
         *
         * 你可以按任何顺序返回答案。
         */
        System.out.println(main.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));// [mee, aqq]
        System.out.println(main.findAndReplacePattern(new String[]{"a","b","c"},"a"));// [a, b, c]
        System.out.println(main.findAndReplacePattern(new String[]{"abc","cba","xyx","yxx","yyx"},"abc")); // [abc, cba]
        System.out.println(main.findAndReplacePattern(new String[]{"abcdefghijklab","abcdefghijkabl"},"abcdefghijklab")); // [abcdefghijklab]

    }
}
