package 双指针.窗口指针;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Cenmo
 * @Date 2022-03-04 2022-03-04
 */
public class 滑动窗口的最大值_单调双端队列 {

    public ArrayList<Integer> maxInWindows2(int [] num, int size) {//暴力
        int left=0,right=size-1;
        int length = num.length;
        ArrayList<Integer> list = new ArrayList<>();
        if(size > length) return list;

        while(right < length){
            int max = num[left];
            for(int i=left;i<=right;i++){
                max = Math.max(max,num[i]);
            }
            list.add(max);
            left++;
            right++;
        }
        return list;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) { // 单调队列
        //单调双向队列：单调：插队入队，且队后元素poll；双向：队首队尾均可入队出队
        Deque<Integer> queue = new LinkedList<>();
        int length = num.length;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<length;i++){
            if(!queue.isEmpty() && i-queue.peek()>size-1){ //右边界与最大元素的间隔元素大于size-1，出队
                queue.pollFirst(); //为什么第一个？
            }
            // 单调队列构建
            while(!queue.isEmpty() && num[i] >= num[ queue.getLast() ]){ //入队元素大于队尾元素，一直出队直到插队合适位置
                queue.pollLast();
            }
            queue.addLast(i);//元素的下标入队

            if(i >= size-1) {
                list.add(num[queue.getFirst()]);
            }
        }
        return list;
    }

    public ArrayList<Integer> maxInWindows_selfDeque(int [] num, int size) { // 指针+数组实现单调队列
        int[] queue = new int[size+1];//queue记录元素下标
        int length = num.length;
        ArrayList<Integer> list = new ArrayList<Integer>();

        int head=0,tail=-1;//队头，队尾
        for(int i=0;i<length;i++){
            if(head<=tail && i-queue[head] > size-1) head++;//出队，i-queue[head]得到滑动窗口内元素个数
            while(head <= tail && num[i]>=num[queue[tail]]) tail--;
            queue[++tail]=i;
            if(i>=size-1) list.add(num[queue[head]]);
        }
        return list;
    }

    public static void main(String[] args) {
        滑动窗口的最大值_单调双端队列 main = new 滑动窗口的最大值_单调双端队列();
        ArrayUtils arrayUtils = new ArrayUtils();

        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1, 3};
//        int[] arr2 = new int[]{9,10,9,-7,-3,8,2,-6};
        arrayUtils.print(arr);
        ArrayList<Integer> list = main.maxInWindows(arr, 3);//[4, 4, 6, 6, 6, 5, 5]
//        ArrayList<Integer> list = main.maxInWindows_selfDeque(arr, 3);//[4, 4, 6, 6, 6, 5, 5]
//        ArrayList<Integer> list2 = main.maxInWindows(arr2, 5);//[10,10,9,8]
        System.out.println(list);
    }
}
