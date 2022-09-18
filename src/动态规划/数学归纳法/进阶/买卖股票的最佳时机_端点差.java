package 动态规划.数学归纳法.进阶;

public class 买卖股票的最佳时机_端点差 {

	public int maxProfit2 (int[] prices) { //双指针.滑动窗口:子序列右端点减左端点的最大值
        // write code here
        int length =prices.length;
        int left=0,right=0,max=0;
        while(right < length){
            if(prices[right] > prices[left]){//贪心
                max = Math.max(max,prices[right]-prices[left]);
            }else{
                left = right;
            }
            right++;
        }
        return max;
    }
    
    public int maxProfit (int[] prices) { //动态规划：递推式的推导
        int length = prices.length;
        int[] dp = new int[length];
        dp[0] = 0;
        // dp[i]描述0,1,2,...i到i的子串
        // 已知dp[i] = max(a[i]-a[0],a[i]-a[1],....,a[i]-a[i])
        // 则dp[i+1] = max(a[i+1]-a[0],a[i+1]-a[1],...a[i+1]-a[i],a[i+1]-a[i+1])
        //           = max(a[i+1]-a[i]+(a[i]-a[0]),a[i+1]-a[i]+(a[i]-a[1]),...a[i+1]-a[i]+(a[i]-a[i]),a[i+1]-a[i]+(a[i]-a[i+1]))
        //           = max(a[i+1]-a[i]+dp[i],0)
        int max=0;
        for(int i=1;i<length;i++){
            dp[i] = Math.max(dp[i-1]+prices[i]-prices[i-1],0);
            System.out.println("dp["+i+"] = " + dp[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

	public static void main(String[] args){
		买卖股票的最佳时机_端点差 stock = new 买卖股票的最佳时机_端点差();

		int[] prices = new int[] {8,9,2,5,4,7,1}; //7-2=5
		// int[] prices = new int[] {2,4,1};
		// int[] prices = new int[] {3,2,1};
		System.out.println( stock.maxProfit(prices) );
		System.out.println( stock.maxProfit2(prices) );
	}
}