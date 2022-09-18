package 数据结构.数组;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-05 2022-03-05
 */
public class 只出现一次的元素二 {
    public int[] deleteDuplicates(int[] arr){
        //数组中重复元素仅重复两次，且未重复元素仅两个
        int yihuo = 0;
        for(int i=0;i<arr.length;i++){ //整个数组异或一次，得到两个未重复元素的异或值
            yihuo ^= arr[i];
        }

        int bitmark = 1;
        while((yihuo & bitmark) == 0) bitmark = bitmark << 1;

        int[] res = new int[2];
        res[0]=0;res[1]=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i] & bitmark) == 0) res[0]^=arr[i];
            else res[1]^=arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        只出现一次的元素二 main = new 只出现一次的元素二();
        ArrayUtils arrayUtils = new ArrayUtils();

        int[] arr = new int[]{1, 8, 6, 7, 3, 9,2, 1, 8, 7, 3, 2}; //重复元素仅重复两次
        arrayUtils.print(arr);
        int[] res = main.deleteDuplicates(arr);//6,9
        arrayUtils.print(res);
    }
}
