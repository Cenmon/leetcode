package 数据结构.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-30 15:17
 * @Description
 */
public class 连接两字母单词得到的最长回文串2131M {

    public int longestPalindrome(String[] words) {
        Map<String,Integer> map1 = new HashMap<>(); // 升序部分回文串
        Map<String,Integer> map2 = new HashMap<>(); // 降序部分回文串
        Map<String,Integer> map3 = new HashMap<>(); // 等字母回文串
        for(String word : words){
            if(word.charAt(0) == word.charAt(1)){
                map3.put(word,map3.getOrDefault(word,0)+1);
            }else{
                String reverse = "" + word.charAt(1) + word.charAt(0);
                if(word.compareTo(reverse) < 0){ // 正序部分回文串直接放
                    map1.put(word,map1.getOrDefault(word,0)+1);
                }else{ // 降序部分回文串翻转后成正序，小于原回文串
                    map2.put(reverse,map2.getOrDefault(reverse,0)+1);
                }
            }
        }
        int ans = 0;
        for(String key : map1.keySet()){
            ans += Math.min(map1.getOrDefault(key,0),map2.getOrDefault(key,0)) * 4;
        }
        boolean hasMedian = false;
        for(int value : map3.values()){
            ans += value/2*2 *2;
            if(value % 2 != 0) hasMedian = true;
        }
        return hasMedian ? ans+2 : ans;
    }

    public int longestPalindrome2(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int ans = 0,median = 0;
        for(String word : words){
            if(word.charAt(0) == word.charAt(1)) median++;
            String reverse = "" + word.charAt(1) + word.charAt(0);
            if(map.containsKey(reverse) && map.get(reverse) > 0){
                ans += 4;
                map.put(reverse,map.get(reverse)-1);
                if(word.charAt(0) == word.charAt(1)) median-=2;
            }else{
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        System.out.println(map + " , " + median);
        return median > 0 ? ans+2 : ans;
    }


    public static void main(String[] args) {
        连接两字母单词得到的最长回文串2131M main = new 连接两字母单词得到的最长回文串2131M();
        /**
         * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
         *
         * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
         *
         * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
         *
         * 回文串 指的是从前往后和从后往前读一样的字符串。
         */
        System.out.println(main.longestPalindrome(new String[]{"lc","cl","gg"})); // 6
        System.out.println(main.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"})); // 8
        System.out.println(main.longestPalindrome(new String[]{"cc","ll","xx"})); // 2
    }
}
