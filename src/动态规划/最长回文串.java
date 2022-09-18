package 动态规划;

public class 最长回文串{

	public int getLongestPalindrome (String A) {
        // write code here
        // 动态规划:空间复杂度n^2 时间复杂度n^2
        char[] str = A.toCharArray();
        int length = str.length,max=0;
        boolean dp[][] = new boolean[length][length];
        
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
                dp[i][j] = false;
        
        for(int len = 0;len<length;len++){//填充矩阵
            for(int i=0;i<length-len;i++){
                int j = i + len ;
                if(i == j) { // 主对角线
                    dp[i][j]=true;
                    max =Math.max(max,len+1);
                }else if(str[i]==str[j] && i+1==j ){ // 主对角右偏
                    dp[i][j]= true;
                    max =Math.max(max,len+1);
                }else if(str[i]==str[j] && dp[i+1][j-1]==true){ //其他位置
                    dp[i][j]= true;
                    max =Math.max(max,len+1);
                }
//                 if(max == 5) System.out.println("i="+i+";j="+j);
                
            }
        }
//         for(int i=0;i<length;i++){
//             for(int j=0;j<length;j++){
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
        
        return max;
    }

    public int violence(String A){
    	char[] str = A.toCharArray();
    	int length = str.length;
    	int max=0;//最大回文串长度

    	for(int i=0;i<length;i++){//左边界
    		for(int j=i;j<length;j++){//右边界
    			if(isPalindrome(str,i,j)){
    				max = Math.max(max,j-i+1);
    			}
    		}
    	}

    	return max;
    }

    public boolean isPalindrome(char[] str,int left,int right){
    	while(left!=right && left+1!=right){
    		if(str[left] != str[right]){
    			return false;
    		}
    		left++;right--;
    	}
    	return true;
    }

	public static void main(String[] args){
		最长回文串 main = new 最长回文串();

		System.out.println(main.getLongestPalindrome("abbba")); // 5
		System.out.println(main.violence("abbba")); // 5
	}

}