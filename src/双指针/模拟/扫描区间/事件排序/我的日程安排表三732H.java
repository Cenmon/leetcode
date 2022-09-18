package 双指针.模拟.扫描区间.事件排序;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Cenmo
 * @Date 2022-09-17 10:35
 * @Description
 */
public class 我的日程安排表三732H {

    class MyCalendarThree {

        private Map<Integer,Integer> map;
        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
            int visited = 0,k = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                visited += entry.getValue();
                if(visited > k) k = visited;
            }
            return k;
        }
    }

    private void run(int[][] arranges){
        MyCalendarThree myCalendar = new MyCalendarThree();
        List<Integer> ans = new ArrayList<>();
        for(int[] arrange : arranges){
            ans.add(myCalendar.book(arrange[0],arrange[1]));
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        我的日程安排表三732H main = new 我的日程安排表三732H();

        /**
         * 传入日程安排时间arrange，表示预约日程的开始时间和结束时间
         * 要求完善MyCalender类，进行每次预订book后，返回此次预订产生的最多的时间冲突次数
         */
        main.run(new int[][]{{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}});
    }
}
