package 双指针.对撞指针.回文串;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 验证回文串 {

    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){ // 去除非字母和数字的字符
                sb.append(Character.toLowerCase(ch));
            }
        }
        int left = 0,right = sb.length() - 1;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }

    public static void main(String[] args) {
        验证回文串 main = new 验证回文串();

        System.out.println(main.isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(main.isPalindrome("race a car"));//false
        System.out.println(main.isPalindrome(" "));//true
    }
}
