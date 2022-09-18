package 双指针.对撞指针.回文串;

/**
 * @author Cenmo
 * @Date 2022-07-11 2022-07-11
 */
public class exp验证回文字符串二680 {

    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int left=0,right=s.length()-1;
        while(left < right && cs[left] == cs[right]){
            left++;right--;
        }
        return left>=right || isPalindrome(cs,left+1,right) || isPalindrome(cs,left,right-1);
    }

    private boolean isPalindrome(char[] cs,int left,int right){
        while(left < right && cs[left] == cs[right]){
            left++;
            right--;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        exp验证回文字符串二680 main = new exp验证回文字符串二680();

        /**
         * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
         */
        System.out.println(main.validPalindrome("aba")); // true
        System.out.println(main.validPalindrome("abca")); // true
        System.out.println(main.validPalindrome("abc")); // false
        // true
        System.out.println(main.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(main.validPalindrome("acxcybycxcxa")); // false

    }
}
