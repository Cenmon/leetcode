package 双指针.异地指针;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-08-24 19:09
 * @Description 区间交集，由于区间已经排序（区间内已交并），因此不需要扫描线算法
 */
public class 区间列表的交集986M_无重叠区间交集 {

    // 仅考虑有交集和没交集的情形
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m=firstList.length,n=secondList.length;
        int i=0,j=0;
        List<int[]> ans = new ArrayList<>();
        while(i < m && j < n){
            if(firstList[i][1] < secondList[j][0]){ // 没有交集，i在前
                i++;
            }else if(secondList[j][1] < firstList[i][0]){ // 没有交集，j在前
                j++;
            }else{ // 有交集
                ans.add(new int[]{Math.max(firstList[i][0],secondList[j][0]),Math.min(firstList[i][1],secondList[j][1])});
                if(firstList[i][1] < secondList[j][1]){
                    i++;
                }else{
                    j++;
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }


    public static void main(String[] args) {
        区间列表的交集986M_无重叠区间交集 main = new 区间列表的交集986M_无重叠区间交集();

        /**
         * 给定两个已经排序的区间二维数组firstList,secondList,返回他们交集的数组
         */
        ArrayUtils.print(main.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},new int[][]{{1,5},{8,12},{15,24},{25,26}}));
        //[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        ArrayUtils.print(main.intervalIntersection(new int[][]{{1,3},{5,9}},new int[][]{}));
        // []
        ArrayUtils.print(main.intervalIntersection(new int[][]{},new int[][]{{4,8},{10,12}}));
        // []
        ArrayUtils.print(main.intervalIntersection(new int[][]{{1,7}},new int[][]{{3,10}}));
        // [[3,7]]
        ArrayUtils.print(main.intervalIntersection(new int[][]{{3,5},{9,20}},new int[][]{{4,5},{7,10},{11,12},{14,15},{16,20}}));
        //[[4,5],[9,10],[11,12],[14,15],[16,20]]
    }
}
