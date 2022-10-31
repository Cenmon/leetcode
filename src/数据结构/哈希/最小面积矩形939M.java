package 数据结构.哈希;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Cenmo
 * @Date 2022-10-29 20:18
 * @Description
 */
public class 最小面积矩形939M {

    public int minAreaRect(int[][] points) { // 矩阵：横平竖直，可以直接枚举对角线
        Map<Integer, Set<Integer>> map = new HashMap<>(); // 横轴为x时的所有纵轴值
        for(int[] p : points){
            if(!map.containsKey(p[0])) map.put(p[0],new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        // System.out.println(map);
        // 枚举对角线
        int ans = Integer.MAX_VALUE;
        for(int i=0,n=points.length;i<n;i++){
            for(int j=i+1;j<n;j++){
                // i,j在同一条水平线或竖直线
                if(points[i][0]==points[j][0] || points[i][1]==points[j][1]) continue;

                // 与i点同竖，以及与j点同竖的点存在
                if(!map.get(points[i][0]).contains(points[j][1])) continue;
                if(!map.get(points[j][0]).contains(points[i][1])) continue;

                ans = Math.min(ans,Math.abs(points[i][0]-points[j][0])*Math.abs(points[i][1]-points[j][1]));
            }
        }

        return ans<Integer.MAX_VALUE ? ans : 0;
    }


    public static void main(String[] args) {
        最小面积矩形939M main = new 最小面积矩形939M();

        /**
         *给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
         *
         * 如果没有任何矩形，就返回 0。
         */

        System.out.println(main.minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}}));//4
        System.out.println(main.minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}}));//2
    }
}
