package 数据结构.数组;

import Utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cenmo
 * @Date 2022-03-05 2022-03-05
 */
public class 只出现一次的元素三 {
    public static void main(String[] args) {
        只出现一次的元素三 main = new 只出现一次的元素三();

        ArrayUtils arrayUtils = new ArrayUtils();

        //重复元素只打印一次
        int[] arr = new int[]{1, 8, 6, 7, 3, 9,2, 1, 8, 7, 3, 2};
        arrayUtils.print(arr);
        int[] res = main.deleteDuplicates(arr);//1,8,6,7,3,9,2
        arrayUtils.print(res);

    }

    private int[] deleteDuplicates(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],i);//记录第一次出现的坐标
        }
        int[] res = new int[map.size()];
        int index=0;
        for(int i=0;i<arr.length;i++){//按照之前出现的顺序
            if(map.get(arr[i]) == i){
                res[index++] = arr[i];
            }
        }
        return res;
    }
}
