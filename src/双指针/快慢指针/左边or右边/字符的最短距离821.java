package 双指针.快慢指针.左边or右边;

/**
 * @author Cenmo
 * @Date 2022-07-23 2022-07-23
 */
public class 字符的最短距离821 {

    public int[] shortestToChar(String s, char c) { // 左右指针
        // char[] cs = s.toCharArray();
        int[] ans = new int[s.length()];
        int n=s.length(),left=-n,right=0; // 左边无限远有一个字符
        while(right < n && s.charAt(right) != c) right++;
        for(int i=0;i<n;i++){
            if(i >= right){
                left = right;
                while(++right < n && s.charAt(right) != c);
                if(right == n) right = 2*n; // 右边无限远有一个字符
            }
            ans[i] = Math.min(Math.abs(i-left),Math.abs(i-right));
        }
        return ans;
    }

    public int[] shortestToChar2(String s, char c) { // 左右扫
        char[] cs = s.toCharArray();
        int[] ans = new int[cs.length];
        int n = s.length(),left=-n,right=2*n;
        for(int i=0;i<n;i++){ // 左扫一遍
            if(cs[i] == c){
                left = i;
            }
            ans[i] = i - left; // 当前字符到左边c字符的距离
        }
        for(int i=n-1;i>=0;i--){ // 右扫一遍
            if(cs[i] == c){
                right = i;
            }
            ans[i] = Math.min(ans[i],right - i); // 当前字符到左c字符与右c字符较小的距离
        }
        return ans;
    }

    public static void main(String[] args) {
        字符的最短距离821 main = new 字符的最短距离821();
    }
}
