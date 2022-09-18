package 数据结构.堆;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Cenmo
 * @Date 2022-03-18 2022-03-18
 * https://www.bilibili.com/video/BV1hi4y1b7z5?from=search&seid=10812192381085573957&spm_id_from=333.337.0.0
 */
public class 数据流中的中位数 {

    // 按照升序排列数据，中位数左侧数据放入大根堆，右侧数据放入小根堆
    Queue<Integer> lMax = new PriorityQueue<>((o1, o2)->o2-o1);
    Queue<Integer> rMin = new PriorityQueue<>();
    int count = 0;


    // 插入排序每次插入合适位置，取值时取中间位置
    // 链表记录数据便于插入
    public void Insert(Integer num) {
        if(count % 2 == 0){
            if(!rMin.isEmpty() && num > rMin.peek()){
                lMax.offer(rMin.poll());
                rMin.offer(num);
            }else{
                lMax.offer(num);
            }
        }else{
            if(!lMax.isEmpty() && num < lMax.peek()){
                rMin.offer(lMax.poll());
                lMax.offer(num);
            }else{
                rMin.offer(num);
            }
        }
        count++;
    }

    public Double GetMedian() {
        if(count == 0) return 0.0;
        if(count % 2 == 0){
            return (double)(lMax.peek()+rMin.peek()) / 2;
        }else{
//            return lMax.size()>rMin.size()?lMax.peek():rMin.peek();
            return (double)lMax.peek(); // 奇数个元素时，经过一次count自增，因此最后一次执行的是放在左边
        }
    }

    public static void main(String[] args) {
        数据流中的中位数 main = new 数据流中的中位数();

        int[] ints = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int anInt : ints) {
            main.Insert(anInt);
            System.out.print(main.GetMedian()+" ");
        }
    }
}
