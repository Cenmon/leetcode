package 双指针.模拟.分三段;

public class 分割两个字符串得到回文串1616M {

    // // @Cenmo:分段问题：分割前后缀，回文分段
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b) || check(b,a);
    }

    // a串和b串均劈成三份，a=a1+a2+a3,b=b1+b2+b3(a1和b1,a2和b2,a3和b3的长度均相同，且a1+b3为回文)
    // 则若在a1,a2之间分割得到字符串a1+b2+b3;在a2,a3之间分割得到字符串a1+a2+b3
    // 即a2或b2为回文串则分割得到的字符串为回文
    private boolean check(String a,String b){
        int left=0,right=b.length()-1;
        while(left < right && a.charAt(left) == b.charAt(right)){
            left++;
            right--;
        }
        if(left >= right) return true;
        return isPalindrome(a.substring(left,right+1)) || isPalindrome(b.substring(left,right+1));
    }

    private boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;right--;
        }
        return left >= right ;
    }


    public static void main(String[] args) {
        分割两个字符串得到回文串1616M main = new 分割两个字符串得到回文串1616M();


        /**
         * 给定两个字符串a,b,在a，b某个"相同位置"做分割，返回a的前缀与b的后缀，或b的前缀与a的后缀是否构成回文串
         * 注：前缀和后缀可以是空串
         */
        System.out.println(main.checkPalindromeFormation("x","y")); // true
        System.out.println(main.checkPalindromeFormation("xbdef","xecab")); // false
        System.out.println(main.checkPalindromeFormation("ulacfd","jizalu")); // true
        System.out.println(main.checkPalindromeFormation("abdef","fecab")); // true
        System.out.println(main.checkPalindromeFormation("abda","acmc")); // false
    }
}
