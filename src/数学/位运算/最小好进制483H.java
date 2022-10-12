package 数学.位运算;

/**
 * @Author Cenmo
 * @Date 2022-10-12 22:01
 * @Description
 */
public class 最小好进制483H {

    // 进制为全为1，则n=(111..1),m个k进制数，则n=k^0+k^1+...k^m-1
    // 由进制表示的k越小，m越大，故求最小进制k，即最大个数m，本题即求最大m，最小k
    // 由k>=2可知，最大个数m为logn/log2,最小为1(n的n进制表示为"1")
    // 由放缩等比公式最后一项k^(m-1)<n，则k<n^(1/(m-1)),开根
    public String smallestGoodBase(String n) {
        long value = Long.parseLong(n);
        for(int m=(int)(Math.log(value)/Math.log(2));m>=1;m--){
            long left=2,right=(int)Math.pow(value,1.0/(m-1)); // k在m确定下的取值范围
            while(left <= right){
                long mid = left + (right-left)/2;

                long sum = 1;
                for(int i=1;i<m;i++){
                    sum = sum*mid + 1; // mid即k进制
                }

                if(sum == value) {
                    return String.valueOf(mid);
                }else if(sum > value){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return String.valueOf(value-1);
    }


    public static void main(String[] args) {
        最小好进制483H main = new 最小好进制483H();

        /**
         * 以字符串的形式给出 n , 以字符串的形式返回 n 的最小 好进制  。
         *
         * 如果 n 的  k(k>=2) 进制数的所有数位全为1，则称 k(k>=2) 是 n 的一个 好进制 。
         */
        System.out.println(main.smallestGoodBase("13"));//3
        System.out.println(main.smallestGoodBase("4681"));//8
        System.out.println(main.smallestGoodBase("1000000000000000000"));//999999999999999999
    }
}
