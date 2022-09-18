package Basic;

public class 判断回文串 {

    public boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        // 判断条件放在while里面，省去if的执行
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        判断回文串 main = new 判断回文串();

        System.out.println(main);
    }
}
