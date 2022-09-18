package Test;

/**
 * @author Cenmo
 * @Date 2022-03-25 2022-03-25
 */
public class test {

    public static void main(String[] args) {

    }

    public static int maxIncome_recur(int[][] incomes,int i,int sum){
        if(i == incomes.length-1){
            return Math.max(incomes[i][0],incomes[i][1]);
        }else{
            return Math.max(maxIncome_recur(incomes,i+1,sum+incomes[i][0]),maxIncome_recur(incomes,i+1,sum+incomes[i][1]));
        }
    }

    public static int maxIncome_dp(int[][] incomes){
        int m=incomes.length;
        int[] dp = new int[m+1];

        dp[0]=0;
        for(int i=1;i<=m;i++){
            dp[i] = Math.max(dp[i-1]+incomes[i][0],dp[i-1]+incomes[i][1]);
        }
        return dp[m];
    }

    public static int  func(int a){
        try{
            int b = 2/a;
            return func2(b);
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }

    public static int func2(int b){
        System.out.println("func2");
        return b;
    }
}
