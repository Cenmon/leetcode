package 数据结构.数组;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-05 2022-03-05
 */
public class 只出现一次的元素一 {

    public int deleteDuplicates(int[] arr){
        //数组中重复元素仅重复两次，且未重复元素仅一个
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans = ans ^ arr[i]; //异或运算 0^a=a a^a=0
        }
        return ans;
    }

    public static void main(String[] args) {
        只出现一次的元素一 main = new 只出现一次的元素一();
        ArrayUtils arrayUtils = new ArrayUtils();

        int[] arr = new int[]{1, 8, 6, 7, 3, 2, 1, 8, 7, 3, 2};
        arrayUtils.print(arr);
        int res = main.deleteDuplicates(arr);
        System.out.println("res = " + res);
    }
}
