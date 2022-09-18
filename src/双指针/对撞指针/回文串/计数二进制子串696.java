package 双指针.对撞指针.回文串;

/**
 * @author Cenmo
 * @Date 2022-07-11 2022-07-11
 */
public class 计数二进制子串696 {

    /**
     * 思路：计算每段连续0,1子串中0,1个数，由01,10满足题意可知，0011,1100也满足，即中心向两边扩展
     * 故每段子串的01个数较小值决定相邻两段的01子串总数
     * @param s
     * @return 具有相同0,1个数的子串总数
     */
    public int countBinarySubstrings(String s) { // 中心扩展
        char[] cs = s.toCharArray();
        int left=0,right=0,n=cs.length;
        int ans = 0;
        for(int i = 0;i <= n;i++){
            if(i==n || cs[i] != cs[right]){
                ans += Math.min(i-right,right-left);
                left = right;
                right = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        计数二进制子串696 main = new 计数二进制子串696();
        /**
         * 给出01字符串，求具有相同0,1个数的子串总数
         */
        System.out.println(main.countBinarySubstrings("00110011")); // 6 子串为"0011"、"01"、"1100"、"10"、"0011" 和 "01"
        System.out.println(main.countBinarySubstrings("10101")); // 4 子串为"10"、"01"、"10"、"01"
    }
}
