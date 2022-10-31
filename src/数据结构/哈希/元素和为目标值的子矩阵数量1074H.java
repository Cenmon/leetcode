package 数据结构.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-29 21:42
 * @Description
 */
public class 元素和为目标值的子矩阵数量1074H {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        Map<Integer,Integer> map = new HashMap<>(); // 前缀和 & count
        int m=matrix.length,n=matrix[0].length;
        int count=0;

        for(int i=0;i<m;i++){ // 上界
            int[] column = new int[n]; // 上界与下界直接的列和
            for(int t=i;t<m;t++){ // 下界

                int presum = 0; // 矩阵前缀和
                map.put(0,1); //
                for(int j=0;j<n;j++){ // 右边界
                    column[j] += matrix[t][j];
                    presum += column[j];
                    // hash优化左边界遍历
                    count += map.getOrDefault(presum-target,0); // 左边界个数
                    map.put(presum,map.getOrDefault(presum,0)+1);
                }

                map.clear(); // 下一行
            }
        }
        return count;
    }


    public static void main(String[] args) {
        元素和为目标值的子矩阵数量1074H main = new 元素和为目标值的子矩阵数量1074H();

        /**
         *给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
         *
         * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
         *
         * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），
         * 那么这两个子矩阵也不同。
         *
         */
        System.out.println(main.numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}},0));//4
        System.out.println(main.numSubmatrixSumTarget(new int[][]{{1,-1},{-1,1}},0));//5
        System.out.println(main.numSubmatrixSumTarget(new int[][]{{904}},0));//0
    }
}
