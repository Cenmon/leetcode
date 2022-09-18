package 双指针.对撞指针.回文串;

public class 删除回文子序列1332E {

    public int removePalindromeSub(String s) {
        int left=0,right=s.length()-1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return 2;
            }
            left++;right--;
        }
        return 1;
    }


    public static void main(String[] args) {
        删除回文子序列1332E main = new 删除回文子序列1332E();

        /**
         * 删除若干个回文子序列，使得仅含a,b的字符串为空，返回最少删除个数
         * tmd：注意回文子序列而非回文串!!!
         */
        System.out.println(main.removePalindromeSub("ababa")); // 1
        System.out.println(main.removePalindromeSub("abb")); // 2
        System.out.println(main.removePalindromeSub("baabb")); // 2
        System.out.println(main.removePalindromeSub("bbaabaaa")); // 2,子序列 bbb,aaaaa
    }
}
