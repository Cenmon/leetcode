package 双指针.模拟.扫描区间.合并区间;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-03-07 2022-03-07
 * @Description 区间并集
 */
public class 合并区间56M_并集 {


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2)->o1[0]-o2[0]);

        List<int[]> list = new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        for(int[] interval : intervals){
            if(interval[0] <= end){
                end = Math.max(end,interval[1]);
            }else{
                list.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start,end});

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        合并区间56M_并集 main = new 合并区间56M_并集();

        ArrayUtils.print(main.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})); // [[1,6],[8,10],[15,18]]
        ArrayUtils.print(main.merge(new int[][]{{1,4},{4,5}})); // [[1,5]]
    }
}
