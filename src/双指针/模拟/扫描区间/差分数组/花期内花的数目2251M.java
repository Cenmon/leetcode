package 双指针.模拟.扫描区间.差分数组;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-09-17 10:20
 * @Description
 */
public class 花期内花的数目2251M {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        List<int[]> events = new ArrayList<>();
        for(int[] flower : flowers){
            events.add(new int[]{flower[0],1});
            events.add(new int[]{flower[1]+1,-1});
        }
        Collections.sort(events,(o1, o2)->o1[0]-o2[0]);

        int personNum=persons.length,eventNum=events.size();
        List<int[]> times = new ArrayList<>();
        for(int i=0;i<personNum;i++){
            times.add(new int[]{persons[i],i});
        }
        Collections.sort(times,(o1,o2)->o1[0]-o2[0]);

        int sum=0,j=0;
        for(int[] time : times){
            while(j<eventNum && events.get(j)[0] <= time[0]){
                sum += events.get(j)[1];
                j++;
            }
            persons[ time[1] ] = sum;
        }
        return persons;
    }


    public static void main(String[] args) {
        花期内花的数目2251M main = new 花期内花的数目2251M();

        /**
         * 给定二维花期数组flowers以及人员看花时间persons，persons数组大小为n
         * flowers数组内元素表示第i多花开花的开始时间和结束时间，persons表示第i个人到达的看花时间
         * 返回大小为n的数组，表示第i个人到达后能够看到的开花数目
         */
        ArrayUtils.print(main.fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}},new int[]{2,3,7,11})); //[1,2,2,2]
        ArrayUtils.print(main.fullBloomFlowers(new int[][]{{1,10},{3,3}},new int[]{3,3,2})); //[2,2,1]
    }
}
