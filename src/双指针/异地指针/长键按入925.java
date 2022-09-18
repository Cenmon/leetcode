package 双指针.异地指针;

/**
 * @author Cenmo
 * @Date 2022-07-31 2022-07-31
 */
public class 长键按入925 {

    public boolean isLongPressedName(String name, String typed) {
        int m=name.length(),n=typed.length();
        int i=0,j=0;
        for(;i<m && j<n;i++,j++){
            if(name.charAt(i) != typed.charAt(j)){
                while(j>0 && j<n && typed.charAt(j) == typed.charAt(j-1)) j++;
                if(j==n || name.charAt(i) != typed.charAt(j)){
                    return false;
                }
            }
        }
        while(j<n && typed.charAt(j) == typed.charAt(j-1)) j++;
        return i==m && j==n;
    }

    public static void main(String[] args) {
        长键按入925 main = new 长键按入925();

        /**
         * 给定名称字符串和键入字符串(typed),typed是否因为多按了几个导致不一致
         */
        System.out.println(main.isLongPressedName("alex","aaleex"));
        System.out.println(main.isLongPressedName("saeed","ssaaedd"));
        System.out.println(main.isLongPressedName("alex","aaleexxa"));
        System.out.println(main.isLongPressedName("kikcxmvzi","kiikcxxmmvvzz"));
    }
}
