package 贪心;

/**
 * @author Cenmo
 * @Date 2022-03-26 2022-03-26
 */
public class 字符分边的最少交换次数 {

    public int exchange(char[] c){
        int exB=0,exG=0;
        int n = c.length;
        int left=0,right=0;
        while(right<n){
            if(c[right] == 'G'){
                exG += right-left;
                left++;
            }
            right++;
        }
        left=0;right=0;
        while(right<n){
            if(c[right] == 'B'){
                exB += right-left;
                left++;
            }
            right++;
        }
//        System.out.println("exB = " + exB);
//        System.out.println("exG = " + exG);
        return Math.min(exB,exG);
    }

    /**
     * 将B,G字符分别放在两侧，只能相邻交换移动，求最小交换次数，可B左G右，也可B右G左
     */
    public static void main(String[] args) {
        字符分边的最少交换次数 main = new 字符分边的最少交换次数();

        String s = "BBGGBBGBG";
        System.out.println(main.exchange(s.toCharArray())); //7
    }
}
