package 双指针.快慢指针.移除元素.模拟栈;

import Utils.ArrayUtils;

public class 重写零1089 {

    public void duplicateZeros2(int[] arr) {
        int n=arr.length, idx = arr.length;
        for(int num : arr){
            if(num == 0) idx++;
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i] != 0){
                if(--idx <= n-1) arr[idx] = arr[i];
            }else{
                if(--idx <= n-1) arr[idx] = 0;
                if(--idx <= n-1) arr[idx] = 0;
            }
        }
    }

    public int[] duplicateZeros(int[] arr) { // 模拟栈
        int n=arr.length,top=0,i=-1;
        // top指向栈顶元素下一个，top值即为元素下标；top:栈内元素个数；top=0:栈空；
        while(top < n){ // 栈内元素个数小于n，栈未满，继续入栈
            if(arr[++i] != 0){
                top++; // 入栈
            }else{
                top+=2;// 入栈两个0
            }
        }
        // 栈满：top=n
        if(top > n){ // top+2有可能导致的栈溢出
            top-=2;
            arr[top] = 0;
            i--;
        }
        while(top > 0){ // 栈非空
            arr[--top] = arr[i];
            if(arr[i] == 0){
                arr[--top] = 0;
            }
            i--;
        }
        return arr;
    }


    public static void main(String[] args) {
        重写零1089 main = new 重写零1089();

        /**
         * 给定数组arr,将内部0重写一次，超过原有数组长度部分舍弃
         */
        ArrayUtils.print(main.duplicateZeros(new int[]{1,0,2,3,0,4,5,0})); // 1,0,0,2,3,0,0,4
        ArrayUtils.print(main.duplicateZeros(new int[]{1,2,3})); // 1,2,3
        ArrayUtils.print(main.duplicateZeros(new int[]{0,0,0,0,0,0,0})); // 1,2,3
    }
}
