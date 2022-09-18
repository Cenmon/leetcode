package 数据结构.排序算法.堆;

import Utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class  最小K个数{

	public int[] GetLeastNumbers_Solution(int [] input, int k){
		int[] ret = new int[k];
        if(k==0) return ret;
        
        int length = input.length;
        for(int i=0;i<k;i++) {
            ret[i] = input[i];
        }
        for(int i=k/2;i>=0;i--){
            HeapAdjust(ret,i,k-1);
        }
        for(int i=k;i<length;i++){
            if(input[i] < ret[0]){
                ret[0] = input[i];
                HeapAdjust(ret,0,k-1);
            }
        }

        return ret;
	}

	public void HeapAdjust(int[] arr,int start,int end){
		int tmp = arr[start];
		for(int i=2*start;i<=end;i*=2){
			if(i<end && arr[i]<arr[i+1]) i++;
			if(tmp >= arr[i]){
				break;
			}else{
				arr[start]=arr[i];//大值上浮
				start = i;//子树下沉
			}
		}
		arr[start]=tmp;
	}

	public int[] GetLeastNumbers_Solution2(int [] input, int k){ //优先队列实现堆

		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);//降序，大根堆
			}
		});
		for(int i=0;i<input.length;i++){
			if(i < k){
				queue.offer(input[i]);
			}else if(queue.peek() > input[i]){
				queue.poll();
				queue.offer(input[i]);
			}
		}
		int[] res = new int[k];
		for(int i=0;i<k;i++)
			res[i] = queue.poll();
		return res;
	}

	public static void main(String[] args){
		最小K个数 obj = new 最小K个数();
		ArrayUtils arrayUtils = new ArrayUtils();

//		int[] parameter = new int[] {0,1,2,1,2};
		int[] parameter = new int[] {4,5,1,6,2,7,3,8};

		arrayUtils.print(parameter);
		int[] res = obj.GetLeastNumbers_Solution2(parameter,3);
		arrayUtils.print(res);
		
	}

}