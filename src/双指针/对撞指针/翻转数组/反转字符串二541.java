package 双指针.对撞指针.翻转数组;

/**
 * @author Cenmo
 * @Date 2022-07-07 2022-07-07
 */
public class 反转字符串二541 {

    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        for(int i=0;i<n;i+=2*k){
            if(n-1-i < k) reverse(c,i,n-1);
            else reverse(c,i,i+k-1);
        }
        return new String(c);
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
        反转字符串二541 main = new 反转字符串二541();

        /**
         * 给出字符串和k，每隔2k[0,2k-1],[2k,4k-1]，反转k个字符，不足k个则全部反转
         */
        System.out.println(main.reverseStr("abcdefg",  2)); // "bacdfeg"
        System.out.println(main.reverseStr("abcd",  2)); // "bacd"
    }
}
