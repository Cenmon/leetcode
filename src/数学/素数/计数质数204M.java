package 数学.素数;

/**
 * @Author Cenmo
 * @Date 2022-09-19 21:46
 * @Description 理解的还不够深
 */
public class 计数质数204M {

    // 求小于n的所有素数:欧拉筛法，是埃氏筛选法的扩展
    public int countPrimes(int n) {
        int[] prime = new int[n];
        int count = 0;
        boolean[] isHeShu = new boolean[n]; // 是否是合数，默认false，即质数
        for(int i=2;i<n;i++){
            if(!isHeShu[i]) prime[count++] = i; // i是素数时，入栈
            for(int j=0;i*prime[j]<n;j++){// 筛掉质因子的所有倍数，且只筛一次(最小质因子)
                isHeShu[ i*prime[j] ] = true;
                if( i%prime[j] == 0 ) break; //等于0则prime[j]是i的最小因子，同时更是i*prime[j]的最小因子，只需筛一次，故结束循环
            }
        }
        return count;
    }

    // 埃氏筛法
    public int countPrimes2(int n) {
        int count=0;
        boolean[] isHeShu = new boolean[n];
        for(int i=2;i<n;i++){
            if(!isHeShu[i]){
                count++;
                if(i*i < n){ // 筛掉区间[2,sqrt(n)]内质数的倍数
                    for(int j=2*i;j<n;j+=i){
                        isHeShu[j] = true;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        计数质数204M main = new 计数质数204M();

        System.out.println(main);
    }
}
