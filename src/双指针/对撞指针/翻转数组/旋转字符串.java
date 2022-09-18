package 双指针.对撞指针.翻转数组;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 旋转字符串 {

    public String rotate(String s,int k){
        char[] ch = s.toCharArray();
        reverse(ch,0,ch.length-1);
        reverse(ch,0,k-1);
        reverse(ch,k,ch.length-1);
        return new String(ch);
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
        旋转字符串 main = new 旋转字符串();
        System.out.println(main.rotate("abcdefg",2)); //fgabcde
    }
}
