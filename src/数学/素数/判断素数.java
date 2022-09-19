package 数学.素数;

/**
 * @Author Cenmo
 * @Date 2022-09-19 22:26
 * @Description 未理解透彻
 */
public class 判断素数 {

    public boolean judgePrime(int n){
        n = (int) Math.sqrt(n);
        /**
         * 质数没有因子，合数的因子分为质因子和非质因子，质因子p<=sqrt(n)
         */
        for(int i=2;i<n;i++){
            if(n % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        判断素数 main = new 判断素数();

        System.out.println(main);
    }
}
