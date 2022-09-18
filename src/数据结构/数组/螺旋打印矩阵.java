package 数据结构.数组;

import Utils.ArrayUtils;

import java.util.ArrayList;

/**
 * @author Cenmo
 * @Date 2022-03-14 2022-03-14
 */
public class 螺旋打印矩阵 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return list;

        int left = 0,right = matrix[0].length-1;
        int up = 0,down = matrix.length-1;

        while(left <= right && up <= down){
            for(int j=left;j<=right;j++)
                list.add(matrix[up][j]);
            for(int i=up+1;i<=down;i++)
                list.add(matrix[i][right]);
            for(int j=right-1;j>=left && down!=up;j--)
                list.add(matrix[down][j]);
            for(int i=down-1;i>=up+1 && left!=right;i--)
                list.add(matrix[i][left]);
            left++;right--;
            up++;down--;
        }
        return list;
    }

    public static void main(String[] args) {
        螺旋打印矩阵 main = new 螺旋打印矩阵();

        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(ints);
        ArrayList<Integer> res = main.spiralOrder(ints);
        System.out.println("res = " + res);
    }
}
