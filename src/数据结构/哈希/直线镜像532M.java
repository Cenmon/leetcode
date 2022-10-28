package 数据结构.哈希;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-28 22:07
 * @Description
 */
public class 直线镜像532M {

    public boolean isReflected(int[][] points) {
        // Write your code here
        if(points.length == 0) return true;
        Arrays.sort(points,(p1, p2)->{
            if(p1[1]==p2[1]) return p1[0]-p2[0];
            return p1[1]-p2[1];
        });
        double pivot=0;
        int size=0,lastX=points[0][0]+1,n=points.length;
        for(int[] p : points){
            if(p[0] == lastX) continue;
            lastX = p[0];

            pivot += p[0];
            size++;
        }
        pivot /= size;

        for(int i=0,j=0;i<n;i++){
            while(j<n && points[i][1]==points[j][1]) j++;

            int left=i,right=j-1;
            while(left <= right && points[left][0]+points[right][0] == 2*pivot){
                while(++left<n && points[left][0] == points[left-1][0]);
                while(--right>=0 && points[right][0] == points[right+1][0]);
            }
            if(left <= right) return false;

            i = j-1;
        }

        return true;
    }


    public static void main(String[] args) {
        直线镜像532M main = new 直线镜像532M();

        /**
         * 给定二维平面上的n点，请问是否有这样一条与y轴平行的线使所有点对称。
         */
        System.out.println(main.isReflected(new int[][]{{1,1},{-1,1}}));// true
        System.out.println(main.isReflected(new int[][]{{1,1},{-1,-1}}));// false
        System.out.println(main.isReflected(new int[][]{}));// true
    }
}
