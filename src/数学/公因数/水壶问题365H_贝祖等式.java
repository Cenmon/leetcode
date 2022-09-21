package 数学.公因数;

/**
 * @Author Cenmo
 * @Date 2022-09-20 14:00
 * @Description
 */
public class 水壶问题365H_贝祖等式 {
    /**
     * 贝祖定理：对任意数a,b,一定有sa+tb=d（d为最大公因数）
     * 整数贝祖定理：若ax+by能够等于z(x,y有解)，当且仅当z是gcd(a,b)的倍数；
     * 当d=gcd(a,b)时，有x=md,y=nd,则amd+bnd=z -> (am+bn)d=z -> z是d的倍数
     */
    public boolean canMeasureWater(int a, int b, int z) {
        if(z == 0) return true;
        return z <= a + b && z % gcd(a,b) == 0;
    }

    private int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }

    public static void main(String[] args) {
        水壶问题365H_贝祖等式 main = new 水壶问题365H_贝祖等式();

        System.out.println(main);
    }
}
