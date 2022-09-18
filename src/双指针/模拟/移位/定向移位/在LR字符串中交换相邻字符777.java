package 双指针.模拟.移位.定向移位;

/**
 * @author Cenmo
 * @Date 2022-07-17 2022-07-17
 */
public class 在LR字符串中交换相邻字符777 {

    public boolean canTransform(String start, String end) {
        char[] cs=start.toCharArray(),target=end.toCharArray();
        int m=cs.length,n=target.length;
        int i=0,j=0;
        while(i<m && j<n){
            while(i<m && cs[i]=='X') i++;
            while(j<n && target[j]=='X') j++;

            if(i<m && j<n){
                if(cs[i] != target[j]) return false;
                if(cs[i] == 'L' && i<j) return false;
                if(cs[i] == 'R' && i>j) return false;
                i++;j++;
            }
        }
        while(i<n && cs[i] == 'X') i++;
        while(j<n && target[j] == 'X') j++;
        return i>=n && j>=n;
    }

    public static void main(String[] args) {
        在LR字符串中交换相邻字符777 main = new 在LR字符串中交换相邻字符777();
        /**
         * start字符串是否能够通过交换得到end
         * 规则：R只能相邻右移，L只能相邻左移，X字符代表空格用于交换
         */
        System.out.println(main.canTransform("RXXLRXRXL", "XRLXXRRLX")); // T
        System.out.println(main.canTransform("X", "L")); // F
        System.out.println(main.canTransform("RXR", "XXR")); // F
    }
}
