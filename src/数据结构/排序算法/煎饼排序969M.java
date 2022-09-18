package 数据结构.排序算法;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.List;

public class 煎饼排序969M {

    /**
     * 主要思想类似于选择排序，每次把最大的元素挑出来，第一次翻转到第一个，第二次翻转到最后一个
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n=arr.length,right=1;
        for(int i=n-1;i>=0;i--){
            int maxIndex=0;
            for(int j=1;j<=i;j++){
                if(arr[j] > arr[maxIndex]) maxIndex=j;
            }
            if(maxIndex != i){
                if(maxIndex != 0){
                    Flip(arr,maxIndex);
                    ans.add(maxIndex+1);
                }
                Flip(arr,i);
                ans.add(i+1);
            }
        }
        return ans;
    }

    private void Flip(int[] arr,int right){
        int left=0;
        while(left < right){
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left] ^= arr[right];
            left++;right--;
        }
    }


    public static void main(String[] args) {
        煎饼排序969M main = new 煎饼排序969M();

        /**
         * 给定数组arr,每次选择第一个元素到第k个元素翻转，最终使得数组升序
         * 返回每次选择的第k个元素的列表
         */
        JavaUtils.print(main.pancakeSort(new int[]{3,2,4,1})); // [3,4,2,3,2]
        JavaUtils.print(main.pancakeSort(new int[]{1,2,3})); // []
        JavaUtils.print(main.pancakeSort(new int[]{3,2,1})); // [3] : 第三个元素翻转得[1,2,3]
        JavaUtils.print(main.pancakeSort(new int[]{3,1,2})); // [3,2] : 第三个元素翻转得[2,1,3],再第二个元素翻转得[1,2,3]
    }
}
