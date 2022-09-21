package 数学.公因数;

/**
 * @Author Cenmo
 * @Date 2022-09-20 12:40
 * @Description
 */
public class 求最大公因数 {

    /**
     * a,b的最大公因数(a,b) = (|a|,|b|) = (b,r) = (gcd,0) = gcd
     * 由欧拉除法和最大公因数的性质，当a=qb+r时，(a,b)=(b,r),r=a%b
     * 由贝祖等式，gcd=ax+by,(x,y为确定的数)
     */
    public int greatestCommonFacotr(int a,int b){
        return gcd(Math.abs(a),Math.abs(b));
    }

    // 辗转相除法
    private int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
//        return b==0 ? a : gcd(b,a%b);
    }


    public static void main(String[] args) {
        求最大公因数 main = new 求最大公因数();

        System.out.println(main.gcd(-14,-7));
    }
}
