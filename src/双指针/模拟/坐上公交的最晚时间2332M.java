package 双指针.模拟;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-08-22 2022-08-22
 * @Description 纯模拟
 */
public class 坐上公交的最晚时间2332M {
    /**
     * 设想公交车启动时间和乘客到达时间坐落于一维数轴，每个公交启动时间点能带走capacity个(-,start]个乘客
     * 分析最后一个乘客和最后一班车的位置关系，
     * 最后一班公交车没满，最后一个乘客可在公交启动时间之后，之前，正好启动到达
     * 最后一班公交车满，
     */
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int m=buses.length,n=passengers.length;
        int top=0,cap=0;
        for(int bus : buses){
            cap = capacity;
            while(cap>0 && top<n && passengers[top] <= bus){
                top++;
                cap--;
            }
        }

        top--; // 指向最后一位上车的乘客
        if(cap > 0) {
            if(top == -1 || passengers[top] != buses[m-1]){
                return buses[m-1];
            }
        }

        int ans = cap>0 ? buses[m-1]-1 : passengers[top]-1;
        while(top-1>=0 && ans == passengers[top-1]){
            ans--;
            top--;
        }
        return ans; // 比最后一位乘客早一分钟
    }


    public static void main(String[] args) {
        坐上公交的最晚时间2332M main = new 坐上公交的最晚时间2332M();

        /**
         * 给定公交车启动时间buses，乘客到达时间passengers,公交车容量capacity
         * 公交车启动只能带走capacity个小于或等于启动时间的乘客，且同一个时间只能到一个人
         * 返回能够最后坐上公交车的最晚时间
         */

        System.out.println(main.latestTimeCatchTheBus(new int[]{10,20},new int[]{2,17,18,19},2));//16
        System.out.println(main.latestTimeCatchTheBus(new int[]{20,30,10},new int[]{19,13,26,4,25,11,21},2));//20
        System.out.println(main.latestTimeCatchTheBus(new int[]{3},new int[]{2,4},2));//3
        System.out.println(main.latestTimeCatchTheBus(new int[]{3},new int[]{4},1));//3
        System.out.println(main.latestTimeCatchTheBus(new int[]{2},new int[]{2},2));//1
        System.out.println(main.latestTimeCatchTheBus(new int[]{2,3},new int[]{3,2},2));//1
    }
}
