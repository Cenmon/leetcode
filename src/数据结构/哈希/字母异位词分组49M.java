package 数据结构.哈希;

import Utils.JavaUtils;

import java.util.*;

/**
 * @Author Cenmo
 * @Date 2022-10-26 10:28
 * @Description
 */
public class 字母异位词分组49M {

    public List<List<String>> groupAnagrams(String[] strs) { //排序后的字符串作为key值：内存80%
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

     public List<List<String>> groupAnagrams2(String[] strs) { // 字符计数数组转化的字符串作key值：内存3%
         Map<String,List<String>> map = new HashMap<>();
         for(String s : strs){
             int[] cnt = new int[26];
             for(int i=0,n=s.length();i<n;i++){
                 cnt[ s.charAt(i)-'a' ]++;
             }
             String key = intsToString(cnt);
             List<String> list = map.getOrDefault(key,new ArrayList<String>());
             list.add(s);
             map.put(key,list);
         }
         return new ArrayList<>(map.values());
     }

     private String intsToString(int[] nums){
         StringBuffer sb = new StringBuffer();
         for(int num : nums){
             sb.append(num);
             sb.append('#');
         }
         return sb.toString();
     }


    public static void main(String[] args) {
        字母异位词分组49M main = new 字母异位词分组49M();

        /**
         * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
         *
         * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
         */
        JavaUtils.print(main.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));//[[eat, tea, ate], [bat], [tan, nat]]
        JavaUtils.print(main.groupAnagrams(new String[]{""}));//[[]]
        JavaUtils.print(main.groupAnagrams(new String[]{"a"}));//[[a]]
        JavaUtils.print(main.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}));//[[bdddddddddd], [bbbbbbbbbbc]]
    }
}
