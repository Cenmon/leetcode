package 数据结构.数组;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-05 2022-03-05
 */
public class 顺时针旋转矩阵 {

    public int[][] rotateMatrix2(int[][] mat, int n) {
        // write code here
        int[][] res = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[j][n-1-i] = mat[i][j];
            }
        }
        return res;
    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        for(int i=0;i<n;i++){ //转置操作
            for(int j=0;j<i;j++){
                int tmp=mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i]=tmp;
            }
        }
        for(int i=0;i<n;i++){ //轴对称
            for(int j=0;j<n/2;j++){
                int tmp=mat[i][n-1-j];
                mat[i][n-1-j] = mat[i][j];
                mat[i][j]=tmp;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        顺时针旋转矩阵 main = new 顺时针旋转矩阵();

        int[][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(mat);
        int[][] ints = main.rotateMatrix(mat, mat.length);
        arrayUtils.print(ints);
    }
}
