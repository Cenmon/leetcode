package 双指针.快慢指针.左边or右边;

/**
 * @author Cenmo
 * @Date 2022-07-29 2022-07-29
 */
public class 推多米诺838 {

    public String pushDominoes(String dominoes) { // 左右指针
        char[] cs = dominoes.toCharArray();
        int left=-1,right=0,n=cs.length;
        while(right<n && cs[right] == '.') right++;
        char l='L',r= right != n ? cs[right] : 'R'; // 左边无限远有一个L，右边无限远有一个R
        for(int i=0;i<n;i++){
            if(i >= right){
                left = right;
                l = r;

                while(++right < n && cs[right] == '.');
                r = right != n ? cs[right] : 'R';
            }

            if(l == r) cs[i] = l;
            else if( l == 'R' && r == 'L'){
                if(i-left < right-i) cs[i] = l;
                else if(i-left > right-i) cs[i] = r;
//                else // 距离左边的R和右边的L相等，左右力平衡
            }
//            else // 坐标是L，右边是R，中间无影响
        }
        return new String(cs);
    }

    public String pushDominoes2(String dominoes) { // 左右扫
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] leftR = new int[n]; // 距离左边的R的距离
        for(int i=0,R=-2*n;i<n;i++){
            if(cs[i] == 'R') R = i;
            else if(cs[i] == 'L') R = -2*n;
            leftR[i] = i - R;
        }
        int[] rightL = new int[n];
        for(int i=n-1,L=2*n;i>=0;i--){
            if(cs[i] == 'L') L = i;
            else if(cs[i] == 'R') L = 2*n;
            rightL[i] = L - i;
        }
        for(int i=0;i<n;i++){
            if(leftR[i] > n && rightL[i] > n) cs[i] = '.';
            else if(leftR[i] < rightL[i]) cs[i] = 'R';
            else if(leftR[i] > rightL[i]) cs[i] = 'L';
            else cs[i] = '.';
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        推多米诺838 main = new 推多米诺838();

        /**
         * R代表向右倒，L向左倒，.代表直立，给定字符串代表左右受力情况，返回受力之后的倒伏情况
         */
        System.out.println(main.pushDominoes2("RR.L")); // RR.L
        System.out.println(main.pushDominoes2(".L.R...LR..L..")); // LL.RR.LLRRLL..
        System.out.println(main.pushDominoes2(".")); // .
    }
}
