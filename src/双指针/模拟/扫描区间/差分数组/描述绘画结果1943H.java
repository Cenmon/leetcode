package 双指针.模拟.扫描区间.差分数组;

import java.util.*;

/**
 * @Author Cenmo
 * @Date 2022-09-17 20:14
 * @Description
 */
public class 描述绘画结果1943H {

    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer,Long> events = new TreeMap<>();
        for(int[] segment : segments){
            events.put(segment[0],events.getOrDefault(segment[0],0L)+segment[2]);
            events.put(segment[1],events.getOrDefault(segment[1],0L)-segment[2]);
        }
        List<List<Long>> ans = new ArrayList<>();
        long sum = 0;
        int start=-1,end=-1;

        for(Map.Entry<Integer,Long> event : events.entrySet()){
            if(sum != 0) {
                start = end;
                end = event.getKey();
                ans.add(Arrays.asList((long)start,(long)end,sum));
            }else{
                end=event.getKey();
            }
            sum += event.getValue();
        }
        return ans;
    }


    public static void main(String[] args) {
        描述绘画结果1943H main = new 描述绘画结果1943H();

        /**
         * 给定二维数组segments,setgments[i]=(start,end,color),
         * 即一维画轴从开区间[start,end)染color色，若有重叠，则重叠颜色相加
         * 返回二维数组painting，painting[i]=(left,right,sum),表示[left,right)染sum色
         */

        System.out.println(main.splitPainting(new int[][]{{1,4,5},{4,7,7},{1,7,9}})); // [[1,4,14],[4,7,16]]
        System.out.println(main.splitPainting(new int[][]{{1,2,8},{5,7,9},{6,8,15},{8,10,7}})); // [[1,2,8],[5,6,9],[6,7,24],[7,8,15],[8,10,7]]
        System.out.println(main.splitPainting(new int[][]{{1,4,5},{1,4,7},{4,7,1},{4,7,11}})); // [[1,4,12],[4,7,12]]
    }
}
