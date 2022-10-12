package 双指针.窗口指针;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-07-10 2022-07-10
 */
public class 找到K个最接近的元素658M {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left=0,right=n-1;
        while(right - left + 1 > k){
            if(Math.abs(arr[right]-x) >= Math.abs(arr[left]-x)){
                right--;
            }else{
                left++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=left;i<=right;i++){
            list.add(arr[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        找到K个最接近的元素658M main = new 找到K个最接近的元素658M();
        /**
         * 在给定数组arr中找到k个最接近x的元素
         */
        JavaUtils.print(main.findClosestElements(new int[]{1,2,3,4,5},4,3)); // [1,2,3,4]
        JavaUtils.print(main.findClosestElements(new int[]{1,2,3,4,5},4,-1)); // [1,2,3,4]
    }
}
