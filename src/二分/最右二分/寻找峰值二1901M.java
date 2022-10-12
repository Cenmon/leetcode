package 二分.最右二分;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-10-12 16:06
 * @Description
 */
public class 寻找峰值二1901M {

    public int[] findPeakGrid(int[][] mat) {
        int left=0,right=mat.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            int upper_max = max_element(mat,mid-1);
            int mid_max = max_element(mat,mid);
            int lower_max = max_element(mat,mid+1);

            int max = Math.max(upper_max,Math.max(lower_max,mid_max));
            if(max == mid_max){
                for(int i=0,n=mat[mid].length;i<n;i++){
                    if(mat[mid][i] == mid_max){
                        return new int[]{mid,i};
                    }
                }
            }else if(max == upper_max){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    // private int[] dp = new int[500];
    private int max_element(int[][] mat,int row){
        if(row < 0 || row >= mat.length) return -1;
        // if(dp[row] > 0) return dp[row];
        int max = mat[row][0];
        for(int num : mat[row]){
            if(num > max){
                max = num;
            }
        }
        // dp[row] = max;
        return max;
    }


    public static void main(String[] args) {
        寻找峰值二1901M main = new 寻找峰值二1901M();

        /**
         * 给定二维矩阵mat,找出二维矩阵中某个位置mat[i][j]，严格大于相邻(上下左右)所有格子
         * 峰值可能有多个，返回任意一个
         */
        ArrayUtils.print(main.findPeakGrid(new int[][]{{1,4},{3,2}}));//[0, 1]
        ArrayUtils.print(main.findPeakGrid(new int[][]{{10,20,15},{21,30,14},{7,16,32}}));//[2, 2]
        ArrayUtils.print(main.findPeakGrid(new int[][]{{7,2,3,1,2},{6,5,4,2,1}}));//[0, 0]
    }
}
