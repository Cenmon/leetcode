package 双指针.模拟;

/**
 * @Author Cenmo
 * @Date 2022-08-22 2022-08-22
 * @Description
 */
public class 一次编辑_面0105M {

    public boolean oneEditAway(String first, String second) {
        int m = first.length(),n = second.length();
        if( m == n && countDiffAlpha(first,second) < 2){
            return true;
        }
        if( Math.abs(m-n) == 1 ){
            if(isSubsequence(first,second) || isSubsequence(second,first)){
                return true;
            }
        }
        return false;
    }

    private int countDiffAlpha(String s,String t){
        int i=0,n=s.length(),count=0;
        while(i<n){
            if(s.charAt(i) != t.charAt(i)){
                count++;
            }
            i++;
        }
        return count;
    }

    private boolean isSubsequence(String s,String t){
        int i=0,j=0,m=s.length(),n=t.length();
        if(m == 0 ) return true;
        if(n == 0) return false;
        while(j < n){
            if(i<m && s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i>=s.length();
    }


    public static void main(String[] args) {
        一次编辑_面0105M main = new 一次编辑_面0105M();

        /**
         * 给定两个字符串first,second，返回first是否能够通过一次或零次增加，删除，替换字符串得到second
         */

        System.out.println(main.oneEditAway("horse","ros")); // false
        System.out.println(main.oneEditAway("pale","ple")); // true
        System.out.println(main.oneEditAway("pales","pal"));// false
        System.out.println(main.oneEditAway("","a"));// true
        System.out.println(main.oneEditAway("a",""));// true
        System.out.println(main.oneEditAway("a","ab"));// true
    }
}
