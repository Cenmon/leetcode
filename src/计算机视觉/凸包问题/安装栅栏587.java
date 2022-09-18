package 计算机视觉.凸包问题;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-07-22 2022-07-22
 */
public class 安装栅栏587 {

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        /* 按照 x 大小进行排序，如果 x 相同，则按照 y 的大小进行排序 */
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
//        for(int i=0;i<n;i++){
//            System.out.print("["+trees[i][0]+","+trees[i][1]+"],");
//        }
//        System.out.println();

        List<Integer> hull = new ArrayList<>();
        boolean[] used = new boolean[n];
        /* hull[0] 需要入栈两次，不进行标记 */
        hull.add(0);
        /* 求出凸包的下半部分 */
        for (int i = 1; i < n; i++) {
            while (hull.size() > 1 && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                used[hull.get(hull.size() - 1)] = false;
                hull.remove(hull.size() - 1);
            }
            used[i] = true;
            hull.add(i);
        }

//        for(int i : hull){
//            System.out.println(trees[i][0]+" , "+trees[i][1]);
//        }

        int m = hull.size();
        /* 求出凸包的上半部分 */
        for (int i = n - 2; i >= 0; i--) {
            if (!used[i]) {
                while (hull.size() > m && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                    used[hull.get(hull.size() - 1)] = false;
                    hull.remove(hull.size() - 1);
                }
                used[i] = true;
                hull.add(i);
            }
        }
        /* hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0] */
        hull.remove(hull.size() - 1);
        int size = hull.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = trees[hull.get(i)];
        }
        return res;
    }

    /**
     * 向量叉积的应用：判断目标向量在当前向量方向的逆时针还是顺时针，服从右手法则
     * 逆时针叉积为正，顺时针叉积为负
     */
    public int cross(int[] p, int[] q, int[] r) {
        // 向量pq与向量qr的叉积(行列式拆开)
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    public static void main(String[] args) {
        安装栅栏587 main = new 安装栅栏587();

        /**
         * 给出二维坐标点，求围住所有点的区域，返回区域点的坐标
         */
        int[][] mat = new int[][]{{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        ArrayUtils.print(mat);
        ArrayUtils.print(main.outerTrees(mat));
    }
}
