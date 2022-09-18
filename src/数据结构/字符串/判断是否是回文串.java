package 数据结构.字符串;

/**
 * @author Cenmo
 * @Date 2022-03-18 2022-03-18
 */
public class 判断是否是回文串 {

    public boolean judge (String str) {
        // write code here
        for(int i=0,j=str.length()-1;i<=j;i++,j--){
            if(str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        判断是否是回文串 main = new 判断是否是回文串();

        System.out.println(main.judge("absba")); // true
        System.out.println(main.judge("ranko")); // false
        System.out.println(main.judge("yamatomaya")); // false
        System.out.println(main.judge("a")); //true
    }
}
