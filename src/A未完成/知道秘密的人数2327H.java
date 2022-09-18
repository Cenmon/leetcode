package A未完成;

/**
 * @Author Cenmo
 * @Date 2022-09-17 19:36
 * @Description 据说动态规划+差分数组
 */
public class 知道秘密的人数2327H {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] diff = new int[n+1];

        int sum = 0;
        diff[1] = 1;
        for(int i=1;i<=n;i++){
            sum += diff[i];


            for(int j=i+delay;j<i+forget;j++)
                diff[ i+delay ] += 1;
            diff[ i+forget ] -= 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        知道秘密的人数2327H main = new 知道秘密的人数2327H();

        System.out.println(main);
    }
}
