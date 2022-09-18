package 数据结构;

import Utils.ArrayUtils;

import java.util.HashSet;

/**
 * @author Cenmo
 * @Date 2022-03-13 2022-03-13
 */
public class 最长连续子序列_Set {

    public int MLS (int[] arr) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        int res=0;
        for(int num : arr)
            set.add(num);
        for(int i=0;i<arr.length;i++){
            int down = arr[i]-1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            int up = arr[i]+1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            res = Math.max(res,up-down-1);
        }
        return res;
    }

    public static void main(String[] args) {
        最长连续子序列_Set main = new 最长连续子序列_Set();

        int[] ints = {100,4,200,1,3,2}; // 最长连续子序列：1,2,3,4 最终返回长度4
        ArrayUtils.print(ints);
        System.out.println("mls = " + main.MLS(ints));
    }
}
