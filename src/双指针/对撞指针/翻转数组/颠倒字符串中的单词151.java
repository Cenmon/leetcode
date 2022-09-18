package 双指针.对撞指针.翻转数组;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 颠倒字符串中的单词151 {

    public String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+"); // 空格分割字符串，在逆置，最后添加空格

        List<String> strings = Arrays.asList(words);
        Collections.reverse(strings);
        return String.join(" ",strings);
    }

    public String reverseWords(String s) { // 翻转字符串
        char[] ch = s.toCharArray();
        int end=removeSpace(ch); // 去空格，返回最终有效长度
        int left=0,right=0;
        reverse(ch,0,end); // 整个字符串逆置
        while(right <=  end){
            left = right;
            while(right <=  end && ch[right] != ' '){ // right指向末尾+1或指向空格跳出循环
                right++;
            }
            reverse(ch,left,right-1); // 非空格单词部分逆置
            right++;//跳过空格
        }
        return new String(Arrays.copyOfRange(ch,0,end+1)); // 左闭右开
    }

    private int removeSpace(char[] ch){ // 移除元素
        int left=0,right=0,end = ch.length-1;
        while(ch[end] == ' ') end--; // 去除右边的空格
        while(right <= end){
            if( ch[right] != ' ' ){
                ch[left++] = ch[right];
            }else{
                if(left > 0 && ch[left-1] != ' '){
                    ch[left++] = ch[right];
                }
            }
            right++;
        }
        return left-1;// 返回最终有效位置
    }

    private void reverse(char[] ch, int left, int right) {
        while(left < right){
            ch[left] ^= ch[right];
            ch[right] ^= ch[left];
            ch[left] ^= ch[right];
            left++;right--;
        }
    }

    public static void main(String[] args) {
        颠倒字符串中的单词151 main = new 颠倒字符串中的单词151();

        System.out.println(main.reverseWords("the sky  is blue"));
        System.out.println(main.reverseWords("  hello world  "));
        System.out.println(main.reverseWords("a good   example"));
        System.out.println(main.reverseWords(" asdasd df f"));


    }
}
