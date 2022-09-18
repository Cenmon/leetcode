package 双指针.模拟.扫描区间.事件排序;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Cenmo
 * @Date 2022-09-16 20:14
 * @Description
 */
public class 拼车1094M {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> events = new TreeMap<>();
        for(int[] trip : trips){
            events.put(trip[1],events.getOrDefault(trip[1],0)+trip[0]);
            events.put(trip[2],events.getOrDefault(trip[2],0)-trip[0]);
        }
        int num = 0;
        for(Map.Entry<Integer,Integer> event : events.entrySet()){
            num += event.getValue();
            if(num > capacity) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        拼车1094M main = new 拼车1094M();

        /**
         * 给定汽车容量capacity和一个数组 trips,trip[i]=[numPassengers,from,to]
         * 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。
         * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
         */
        System.out.println(main.carPooling(new int[][]{{2,1,5},{3,3,7}},4)); // false
        System.out.println(main.carPooling(new int[][]{{2,1,5},{3,3,7}},5)); // true
    }
}
