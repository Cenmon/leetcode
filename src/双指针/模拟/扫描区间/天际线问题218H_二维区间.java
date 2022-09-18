package 双指针.模拟.扫描区间;

import Utils.JavaUtils;

import java.util.*;

/**
 * @Author Cenmo
 * @Date 2022-08-24 2022-08-24
 * @Description 天际线问题：扫描线算法，线段树算法
 * 扫描线算法：通常用于每个分割区间的重叠数目(如当前区间有三条线段重叠，下一区间有两条线段重叠)，重叠信息
 * 主要思想：通过设置进入区间和离开区间的事件对重叠部分进行计算
 * 做法：通常创建类描述事件，后可用Map<pos,Event>或List<Event>记录事件，再进一步进行排序处理
 * 线段树见：https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/218.The-Skyline-Problem
 */
class Event{
    int pos;
    int height;
    boolean isUp;
    Event(){}

    public Event(int pos,int height,boolean isUp){
        this.pos = pos;
        this.height = height;
        this.isUp = isUp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "pos=" + pos +
                ", height=" + height +
                ", isUp=" + isUp +
                '}';
    }
}

public class 天际线问题218H_二维区间 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        LinkedList<List<Integer>> ans =  new LinkedList<>();
        List<Event> events = new ArrayList<>(); // Event:建筑位置 - (高度，是否上升)
        for(int[] building : buildings){
            events.add(new Event(building[0],building[2],true)); // 记录上升沿端点
            events.add(new Event(building[1],building[2],false)); // 记录下降沿端点
        }
        Collections.sort(events, (o1, o2) -> o1.pos - o2.pos);

        Queue<Integer> heights =new PriorityQueue<>((o1,o2)->o2-o1);
        int idx = 0,n = events.size();
        for(Event event : events){
            if(event.isUp){
                heights.add(event.height);
            }else{
                heights.remove(event.height);
            }
            if(++idx < n && events.get(idx).pos == event.pos) continue;

            int maxHeight = heights.isEmpty() ? 0 : heights.peek();
            if(ans.isEmpty() || ans.getLast().get(1) != maxHeight){
                ans.add(Arrays.asList(event.pos,maxHeight));
            }
//            System.out.println(heights.toString() + " , " + ans.toString());
        }
        return ans;
    }


    public static void main(String[] args) {
        天际线问题218H_二维区间 main = new 天际线问题218H_二维区间();

        /**
         * 给定建筑信息的二维数组，其中buildings[i]包含建筑在数轴上的起始位置，终止位置，建筑高度
         * 返回从远处看时，包含所有建筑的轮廓
         * (用二维坐标点返回，返回每个水平线段的左端点，最后一个点为建筑终点，且同一高度只能一个左端点）
         */
        JavaUtils.print(main.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
        // [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]
        JavaUtils.print(main.getSkyline(new int[][]{{0,2,3},{2,5,3}}));
        // [[0,3],[5,0]]
        JavaUtils.print(main.getSkyline(new int[][]{{0,3,3},{1,5,3},{2,4,3},{3,7,3}}));
        // [[0,3],[7,0]]
    }
}
