package 双指针.模拟.扫描区间.事件排序;

import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * @Author Cenmo
 * @Date 2022-09-15 20:01
 * @Description
 */
public class 会议室二253M {

    public int minMeetingRooms(int[][] intervals){ // 扫描线法
        List<Point> events = new ArrayList<>();
        for(int[] interval : intervals){
            events.add(new Point(interval[0],1));
            events.add(new Point(interval[1],-1));
        }
        Collections.sort(events,(o1,o2)->o1.x-o2.x);
        int visited = 0;
        int ans = 0;
        for (Point event : events) {
            visited += event.y;
            if(visited > ans) ans = visited;
        }
        return ans;
    }

    public int minMeetingRooms2(int[][] intervals){ // 模拟法
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]); // 按会议开始时间排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]); // 正在进行的会议，队头为最早结束的会议
        int ans = 0;
        for(int[] interval : intervals){ // 按顺序开会
            if(queue.isEmpty() || queue.peek()[1] > interval[0]){ // 是否需要占据新的会议室
                queue.offer(interval);
                continue;
            }
            ans = Math.max(ans,queue.size());
            queue.poll(); // 会议结束
        }
        return ans;
    }


    public static void main(String[] args) {
        会议室二253M main = new 会议室二253M();

        /**
         * 给定会议开始和结束时间intervals，其中有部分会议的时间冲突
         * 返回最少间会议室，使所有会议顺利进行
         */
        System.out.println(main.minMeetingRooms2(new int[][]{{0,30},{5,10},{15,20}})); // 2
        System.out.println(main.minMeetingRooms2(new int[][]{{7,10},{2,4}})); // 1
    }
}
