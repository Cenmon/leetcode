package A未完成;

import Utils.ArrayUtils;

import java.util.*;

/**
 * @Author Cenmo
 * @Date 2022-08-24 20:08
 * @Description 未解决，扫描线扫描重叠部分
 *
 */

class Event2518{
    int pos;
    int day;
    boolean isStart;
    Event2518(){}
    Event2518(int pos,int day,boolean isStart){
        this.pos = pos;
        this.day = day;
        this.isStart = isStart;
    }

    @Override
    public String toString() {
        return "Event2518{" +
                "pos=" + pos +
                ", day=" + day +
                ", isStart=" + isStart +
                '}';
    }
}

public class 每天绘制新区域的数量2158H {

    public int[] amountPainted(int[][] paint){
        Map<Integer, List<Event2518>> events = new HashMap<>(); // pos,isStart
        int n=paint.length;
        for(int i=0;i<n;i++){
            List<Event2518> list1 = events.getOrDefault(paint[i][0],new ArrayList<>());
            List<Event2518> list2 = events.getOrDefault(paint[i][1],new ArrayList<>());
            list1.add(new Event2518(paint[i][0],i,true));
            list2.add(new Event2518(paint[i][1],i,false));
            events.put(paint[i][0],list1);
            events.put(paint[i][1],list2);
        }
        PriorityQueue<Integer> days = new PriorityQueue<>();
        int prePoint = 1,len = 0;
        int[] ans = new int[n];
        for(Map.Entry<Integer, List<Event2518>> event : events.entrySet()){
            for(Event2518 e : event.getValue()){
                if(e.isStart){
                    days.add(e.day);
                }else{
                    days.remove(e.day);
                }
                System.out.println(e);
            }
            if(!days.isEmpty()){
                ans[days.peek()] += event.getKey() - prePoint;
                prePoint = event.getKey();
                len = Math.max(len,days.peek());
            }
//            System.out.println(days.peek()+" , " + days.toString());
        }
        return Arrays.copyOf(ans,len+1);
    }

    public int[] amountPainted2(int[][] paint){
        List<Event2518> events = new ArrayList<>();
        int n=paint.length;
        for(int i=0;i<n;i++){
            events.add(new Event2518(paint[i][0],i,true));
            events.add(new Event2518(paint[i][1],i,false));
        }
        Collections.sort(events,(o1,o2)->{
            return o1.pos-o2.pos;
        });
        PriorityQueue<Integer> days = new PriorityQueue<>();
        int prePoint = 1,len = 0;
        int[] ans = new int[n];
        for(Event2518 event : events){
            if(event.isStart){
                days.add(event.day);
            }else{
                days.remove(event.day);
            }
            System.out.println(event);

            if(!days.isEmpty()){
                ans[days.peek()] += event.pos - prePoint;
                prePoint = event.pos;
                len = Math.max(len,days.peek());
            }
//            System.out.println(days.peek()+" , " + days.toString());
        }
        return Arrays.copyOf(ans,len+1);
    }

    public static void main(String[] args) {
        每天绘制新区域的数量2158H main = new 每天绘制新区域的数量2158H();

        ArrayUtils.print(main.amountPainted2(new int[][]{{1,4},{4,7},{5,8}}));
    }
}
