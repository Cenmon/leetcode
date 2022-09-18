package 动态规划;

public class 最长公共子序列二 {

	public String LCS (String s1, String s2) {
        // write code here
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int m = cs1.length,n=cs2.length;
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        	for(int j=0;j<=n;j++)
        		if(i==0 || j==0) dp[i][j] = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(cs1[i] == cs2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

		StringBuilder sb = new StringBuilder();
        int i=m,j=n;
        while(i>0 && j>0){
        	if(cs1[i-1] == cs2[j-1]){
        		sb.insert(0,cs1[i-1]);
        		i--;j--;
        	}else{
        		if(dp[i][j-1] > dp[i-1][j]){
        			j--;
        		}else{
        			i--;
        		}
        	}
        }
        return sb.toString();
    }

    public int LCS_violence (String s1,String s2){
    	char[] cs1 = s1.toCharArray();
    	char[] cs2 = s2.toCharArray();


//    	for(int i=0;i)
        return 0;
    }

	public static void main(String[] args){
		最长公共子序列二 main = new 最长公共子序列二();

		// System.out.println(main.LCS("1A2C3D4B56","B1D23A456A")); // "123456"
		System.out.println(main.LCS("abc","def")); //""
		// System.out.println(main.LCS("abc","abc")); //"abc"
	// 	System.out.println(main.LCS("ab","")); // ""
	}

}