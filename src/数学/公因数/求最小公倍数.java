package 数学.公因数;

/**
 * @Author Cenmo
 * @Date 2022-09-21 11:33
 * @Description
 */
public class 求最小公倍数 {

    // 最大公倍数D = a*b/d （d:最小公因数）
    public int LeastCommonMultiple(int a,int b){
        return a * b / gcd(a,b);
    }

    private int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }

    public static void main(String[] args) {
        求最小公倍数 main = new 求最小公倍数();

        System.out.println(main.LeastCommonMultiple(120,150)); // 600
    }
}
