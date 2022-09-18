package 数据结构.哈希;

import java.util.HashSet;
import java.util.Set;

public class 检查整数及其两倍数是否存在1346E {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int x : arr) {
            if(set.contains(x*2) || x%2 == 0 && set.contains(x/2)){
                return true;
            }else{
                set.add(x);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        检查整数及其两倍数是否存在1346E main = new 检查整数及其两倍数是否存在1346E();

        /**
         * 给定数组，判断数组中是否存在某数是另一个数的两倍
         */
        System.out.println(main.checkIfExist(new int[]{10,2,5,3})); // true
        System.out.println(main.checkIfExist(new int[]{7,1,14,11})); // true
        System.out.println(main.checkIfExist(new int[]{3,1,7,11})); // false
        System.out.println(main.checkIfExist(new int[]{-2,0,10,-19,4,6,-8})); // false
        System.out.println(main.checkIfExist(new int[]{0,0})); // true
    }
}
