package 数学.公因数;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-09-21 10:08
 * @Description 贝祖等式：任何数a,b的最大公因数gcd(a,b)可以由sa+tb表示；若ax+by=z,则z是gcd(a,b)的倍数
 */
public class 求贝祖等式st {

    public int[] caculateST(int a,int b){
        if(b == 0) return new int[]{1,0,a};

        int i=2;
        int[][] dp = new int[][]{{0,0,0,a},{1,0,0,b},{0,1,a/b,a%b}}; // si,ti,qi+1,ri+1
        while(dp[i%3][3] != 0){
            i++;
            dp[i%3][0] = dp[(i-2)%3][0] - dp[(i-1)%3][0] * dp[(i-1)%3][2]; // si = si-2 + (-qi-1 * si-1)
            dp[i%3][1] = dp[(i-2)%3][1] - dp[(i-1)%3][1] * dp[(i-1)%3][2]; // ti = ti-2 + (-qi-1 * ti-1)
            dp[i%3][2] = dp[(i-2)%3][3] / dp[(i-1)%3][3]; // qi = ri-2 / ri-1 （整除）
            dp[i%3][3] = dp[(i-2)%3][3] % dp[(i-1)%3][3]; // ri = ri-2 % ri-1
        }
        return new int[]{dp[i%3][0],dp[i%3][1],dp[i%3][0]*a+dp[i%3][1]*b}; // si,ti,gcd(a,b)
    }


    public static void main(String[] args) {
        求贝祖等式st main = new 求贝祖等式st();

        ArrayUtils.print(main.caculateST(1859,1573)); // [-5, 6, 143]
    }
}
