package 双指针.模拟.扫描区间.事件排序;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-09-15 19:40
 * @Description
 */
public class 会议室252M {

    public boolean canAttendMeetings2(int[][] intervals){
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        System.out.println("intervals = " + Arrays.deepToString(intervals));
        int n = intervals.length;
        for(int i=0;i<n-1;i++){
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;
    }

    public boolean canAttendMeetings(int[][] intervals){
        List<Point> events = new ArrayList<>();
        int n = intervals.length;
        for(int[] interval : intervals){
            events.add(new Point(interval[0],1));
            events.add(new Point(interval[1],-1));
        }
        Collections.sort(events,(o1,o2)->o1.x-o2.x);
        int visited = 0;
        for (Point event : events){ // 访问次数
            visited += event.y;
            if(visited > 1) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        会议室252M main = new 会议室252M();

        /**
         * 给定会议开始和结束时间intervals，返回是否能够顺利参加全部会议
         */
        System.out.println(main.canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}})); // true
        System.out.println(main.canAttendMeetings(new int[][]{{7,10},{2,4}})); // false
    }
}
