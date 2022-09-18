package 双指针.窗口指针.计算边界;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-07-17 2022-07-17
 */
public class 情感丰富的文字809 {

    public int expressiveWords(String s, String[] words) {
        char[] cs = s.toCharArray();
        List<Integer> times = new ArrayList<>();
        int left=0,right=0,n=cs.length;
        int len=0,ans=0;
        while(right < n){
            while (right < n && cs[right] == cs[left]) right++;
            cs[len++] = cs[right];
            times.add(right-left);
            left = right;
        }
        int idx=0; // 指向s的各个字符出现次数
        for(String word : words){
            left=0;right=0;n=word.length();idx=0;
            char cr=word.charAt(right),cl=word.charAt(left);
            while(right < n){
                cr = word.charAt(right);
                while(right < n && cr == cl) right++;
                if(cl != cs[idx]) break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        情感丰富的文字809 main = new 情感丰富的文字809();
        StringBuffer sb = new StringBuffer();

    }

}
