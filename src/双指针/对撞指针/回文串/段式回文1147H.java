package 双指针.对撞指针.回文串;

/**
 * @Author Cenmo
 * @Date 2022-09-12 11:02
 * @Description
 */
public class 段式回文1147H {

    public int longestDecomposition(String text) {
        char[] cs = text.toCharArray();
        int left=0,right=cs.length-1,lastRight=right;
        int ans=0;
        while(left <= right){
            while(left<right && cs[right] != cs[left]) right--;
            if(left >= right) {
                return ans+1;
            }

            int i=left,j=right;
            while(j<=lastRight && cs[i] == cs[j]){
                i++;j++;
            }

            if(j > lastRight){
                ans += 2;
                left = i;
                right--;
                lastRight = right;
            }else{
                right--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        段式回文1147H main = new 段式回文1147H();

        /**
         * 给定字符串text，将其分成k段，要求第一段与第k段相等，第二段与第k-1段相等...
         * 返回最大分段数k
         * 如
         * 当text = "ghiabcdefhelloadamhelloabcdefghi"时，k=7
         * 我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
         */
        System.out.println(main.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi")); // 7
        System.out.println(main.longestDecomposition("merchant")); // 1
        System.out.println(main.longestDecomposition("antaprezatepzapreanta")); // 11
        System.out.println(main.longestDecomposition("vwsuvmbwknmnvwsuvmbwk")); // 5
    }
}
