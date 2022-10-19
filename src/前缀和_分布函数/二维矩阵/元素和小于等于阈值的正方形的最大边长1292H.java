package 前缀和_分布函数.二维矩阵;

/**
 * @Author Cenmo
 * @Date 2022-10-19 16:17
 * @Description
 */
public class 元素和小于等于阈值的正方形的最大边长1292H {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length,n = mat[0].length;
        int[][] presum = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                // 求矩阵分布函数值，mat[i-1][j-1]对应为原i,j值
                presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + mat[i-1][j-1];
        // 正方形边长最小为1，但答案可为0，最大为矩阵长宽的较小值
        int left=0,right=Math.min(mat.length,mat[0].length);
        while(left <= right){
            int mid = left + (right-left)/2;
            // 是否存在边长为mid，且正方形内部元素总合小于等于threshold
            // 显然边长为1时满足条件，留作保底
            if(existSquare(presum,threshold,mid)){ // 当存在mid边长的正方形时，增大边长，再次判断是否存在
                left = mid + 1;
            }else{ // 若不存在mid边长的正方形，则mid+1肯定更不存在，因为mid+1的正方形包括mid边长的正方形
                right = mid - 1;
            }
        }
        return right;
    }
    // 是否存在边长为mid，且正方形内部元素总合小于等于threshold
    private boolean existSquare(int[][] presum,int threshold,int edge){
        int m=presum.length,n=presum[0].length;
        for(int i=edge;i<m;i++){
            for(int j=edge;j<n;j++){
                // 求边长为edge的正方形内部元素和：借助二维矩阵分布函数
                if(presum[i][j] - presum[i][j-edge] - presum[i-edge][j] + presum[i-edge][j-edge] <= threshold)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        元素和小于等于阈值的正方形的最大边长1292H main = new 元素和小于等于阈值的正方形的最大边长1292H();

        /**
         * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
         * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0
         */
        System.out.println(main.maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}},4)); // 2
        System.out.println(main.maxSideLength(new int[][]{{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}},1)); // 0
    }
}
