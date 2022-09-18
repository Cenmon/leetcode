package 双指针.对撞指针.翻转数组;

/**
 * @author Cenmo
 * @Date 2022-07-07 2022-07-07
 */
public class 反转字符串中的单词三557 {

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int left=0,right=0,n = cs.length;
        while(right < n){
            while(right < n && cs[right] != ' ') right++;
            reverse(cs,left,right-1);
            right++; // 跳过空格
            left = right; // 指向单词第一个字母
        }
        return new String(cs);
    }

    public void reverse(char[] c,int left,int right){
        while(left < right){
            c[left] ^= c[right];
            c[right] ^= c[left];
            c[left] ^= c[right];
            left++;right--;
        }
    }

    public static void main(String[] args) {
        反转字符串中的单词三557 main = new 反转字符串中的单词三557();

        /**
         * 每个单词进行反转，空格已清除，是151颠倒字符串中的单词的一小部分
         */
        System.out.println(main.reverseWords("Let's take LeetCode contest"));
        System.out.println(main.reverseWords("God Ding"));
    }
}
