package 双指针.对撞指针.翻转数组;

/**
 * @author Cenmo
 * @Date 2022-07-31 2022-07-31
 */
public class 仅仅反转字母917 {

    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        for(int left=0,right=cs.length-1;left < right;left++,right--){
            while(left < right && !isLetter(cs[left])) left++;
            while(left < right && !isLetter(cs[right])) right--;

            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
        }
        return new String(cs);
    }

    private boolean isLetter(char c){
        if('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') return true;
        return false;
    }

    public static void main(String[] args) {
        仅仅反转字母917 main = new 仅仅反转字母917();
        /**
         * 给出含ASCII编码的字符串，翻转其中的字母部分
         */
        System.out.println(main.reverseOnlyLetters("ab-cd")); // dc-ba
        System.out.println(main.reverseOnlyLetters("a-bC-dEf-ghIj")); // j-Ih-gfE-dCba
        System.out.println(main.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // Qedo1ct-eeLg=ntse-T!
    }
}
