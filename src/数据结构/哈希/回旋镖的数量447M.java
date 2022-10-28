package 数据结构.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-27 19:52
 * @Description
 */
public class 回旋镖的数量447M {

    public int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans=0;
        for(int[] x : points){ // 以x点为圆心画圆，map记录在圆上的所有点，则x点出发的回旋镖数量及map里点的排列(要考虑顺序)
            for(int[] y : points){
                int dis = (x[0]-y[0])*(x[0]-y[0]) + (x[1]-y[1])*(x[1]-y[1]);
                map.put(dis,map.getOrDefault(dis,0)+1); // 计算从x点出发，与x距离相等的点y的个数
            }
            for(int num : map.values()){
                ans += num * (num-1); // 选定x和y后，k点即num-1个点里面任意取
            }
            map.clear();
        }
        return ans;
    }


    public static void main(String[] args) {
        回旋镖的数量447M main = new 回旋镖的数量447M();

        /**
         * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
         * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等
         * （需要考虑元组的顺序）。
         *
         * 返回平面上所有回旋镖的数量。
         */
        System.out.println(main.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));// 2
        System.out.println(main.numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}));// 2
        System.out.println(main.numberOfBoomerangs(new int[][]{{1,1}})); // 0
    }
}
