package 双指针.模拟.扫描区间.差分数组;

/**
 * @Author Cenmo
 * @Date 2022-09-17 11:21
 * @Description
 */
public class 字母移位二2381M {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];
        for(int[] shift : shifts){
            if(shift[2] == 0){
                diff[ shift[0] ] -= 1;
                diff[ shift[1]+1 ] += 1;
            }else{
                diff[ shift[0] ] += 1;
                diff[ shift[1]+1 ] -= 1;
            }
        }
        char[] cs = s.toCharArray();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = (sum+diff[i]) % 26;
            cs[i] = (char)('a'+( cs[i]-'a'+ (sum+26)%26 ) % 26) ;
        }
        return new String(cs);
    }


    public static void main(String[] args) {
        字母移位二2381M main = new 字母移位二2381M();
        
        /**
         * 给定字符串s以及字符串变动数组shifts，
         * shifts[i]=(start,end,direction),表示从start到end的字符串往前或后变换，
         * 当direction=0表示向前，为1时向后，如字符'a’向前移一位为‘z'，向后移一位为’b'(循环移动)
         * 返回多次shifts后的字符串
         */
        System.out.println(main.shiftingLetters("abc",new int[][]{{0,1,0},{1,2,1},{0,2,1}})); // "ace"
        System.out.println(main.shiftingLetters("dztz",new int[][]{{0,0,0},{1,1,1}})); // "catz"
    }
}
