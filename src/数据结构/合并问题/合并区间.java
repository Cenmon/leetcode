package 数据结构.合并问题;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Cenmo
 * @Date 2022-03-07 2022-03-07
 */
public class 合并区间 {


    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        Collections.sort(intervals, (o1,o2)->o1.start-o2.start);
        /**
         * new Comparator<Interval>() {
         *             @Override
         *             public int compare(Interval o1, Interval o2) {
         *                 return o1.start-o2.start;
         *             }
         *         }
         */
        int len = intervals.size();
        Interval node = intervals.get(0);
        int start=node.start,end=node.end;
        for(int i=1;i<len;i++){
            node = intervals.get(i);
            if(node.start <= end){
                end = Math.max(node.end,end);
            }else{
                list.add(new Interval(start, end));
                start = node.start;
                end = node.end;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }

    public static void main(String[] args) {
        合并区间 main = new 合并区间();

//        [10,30],[20,60],[80,100],[150,180
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(10, 30));
        list.add(new Interval(20, 60));
        list.add(new Interval(80, 100));
        list.add(new Interval(150, 180));

        ArrayList<Interval> merge = main.merge(list);
        for (Interval interval : merge) {
            System.out.println(interval);
        }
    }
}
