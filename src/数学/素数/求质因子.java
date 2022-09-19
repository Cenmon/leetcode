package 数学.素数;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-09-19 22:34
 * @Description 未理解透彻
 */
public class 求质因子 {

    public List<Integer> primeFactor(int n){// 求n的质因子
        int pn = (int)Math.sqrt(n);
        List<Integer> ans = new ArrayList<>();
        boolean[] isPrime = getPrime(pn);
        for(int i=2;i<pn;i++){ // 求区间[2,sqrt(n)]里的质数
            if(isPrime[i]) ans.add(i);
        }
        return ans;
    }

    private boolean[] getPrime(int n) {
        boolean[] isRes = new boolean[n];
        int[] prime = new int[n];
        int count = 0;
        for(int i=2;i<n;i++){

        }
        return isRes;
    }


    public static void main(String[] args) {
        求质因子 main = new 求质因子();

        System.out.println(main);
    }
}
