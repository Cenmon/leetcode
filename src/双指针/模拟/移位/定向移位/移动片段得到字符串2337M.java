package 双指针.模拟.移位.定向移位;

public class 移动片段得到字符串2337M {

    public boolean canChange(String start, String target) {
        int i=0,j=0,m=start.length(),n=target.length();
        while(i<m && j<n){
            while(i<m && start.charAt(i)=='_') i++;
            while(j<n && target.charAt(j)=='_') j++;

            if(i>=m || j>=n) break;
            if(start.charAt(i) != target.charAt(j)) return false;
            if(start.charAt(i)=='L' && i<j) return false;
            if(start.charAt(i)=='R' && i>j) return false;

            i++;j++;
        }
        while(i<m && start.charAt(i)=='_') i++;
        while(j<n && target.charAt(j)=='_') j++;
        return i>=m && j>=n;
    }

    public static void main(String[] args) {
        移动片段得到字符串2337M main = new 移动片段得到字符串2337M();

        /**
         * 给定原始字符串start和目标字符串target，start中L字符可以左移，R字符可以右移，_代表空位，L和R不能交错
         * 返回start字符能否移动成target
         */
        System.out.println(main.canChange("_L__R__R_","L______RR")); // true
        System.out.println(main.canChange("R_L_","__LR")); // false
        System.out.println(main.canChange("_R","R_")); // false
        System.out.println(main.canChange("_L__R__R__","L______RR_")); // true
    }
}
