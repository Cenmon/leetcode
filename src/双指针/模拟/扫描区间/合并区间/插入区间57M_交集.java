package 双指针.模拟.扫描区间.合并区间;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author Cenmo
 * @Date 2022-09-15 22:36
 * @Description 区间交集：但区间有交集
 */
public class 插入区间57M_交集 {

    public int[][] insert(int[][] intervals, int[] newInterval) { // 合并单个区间适用
        int i=0,n=intervals.length;
        List<int[]> list = new ArrayList<>();
        while(i<n && intervals[i][1] < newInterval[0]){ // 左边无交集处
            list.add(intervals[i]);
            i++;
        }
        // 新旧区间有交集：前面循环已经保证新区间左端点在旧区间里
        // 区间有交集的五种情况：完全重合一种，部分重合两种，端点重合两种
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while(i<n){ // 右侧区间
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[0][]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[0]-o2[0]);
        for(int[] interval : intervals){
            queue.offer(interval);
        }
        queue.offer(newInterval);
        System.out.println(queue.peek()[0]+" , " + queue.peek()[1]);

        List<int[]> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] x = queue.poll(); // 最左侧区间
            if(queue.isEmpty()){
                ans.add(x);
                break;
            }

            int[] y = queue.peek(); // 第二左侧区间
            if(x[1] < y[0]){ // 无交集
                ans.add(x);
            }else{
                queue.poll();
                x[1] = Math.max(x[1],y[1]);
                queue.offer(x); // 放入pq,重新开始
            }
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        插入区间57M_交集 main = new 插入区间57M_交集();

        /**
         * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
         * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
         */
        ArrayUtils.print(main.insert(new int[][]{{1,3},{6,9}},new int[]{2,5})); //[[1,5],[6,9]]
        ArrayUtils.print(main.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8})); //[[1,2],[3,10],[12,16]]
        ArrayUtils.print(main.insert(new int[][]{},new int[]{5,7}));//[[5,7]]
        ArrayUtils.print(main.insert(new int[][]{{1,5}},new int[]{2,3}));//[[1,5]]
        ArrayUtils.print(main.insert(new int[][]{{1,5}},new int[]{2,7}));// [[1,7]]
    }
}
