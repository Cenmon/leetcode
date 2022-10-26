package 双指针.对撞指针.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-26 17:09
 * @Description
 */
public class 两数之和三之数据结构设计170 {

    // private List<Integer> list = new ArrayList<>();
    // public void add(int number) {
    //     // write your code here
    //     list.add(search(number), number);
    // }

    // private int search(int num){ // 最右二分
    //     int left=0,right=list.size()-1;
    //     while(left <= right){
    //         int mid = left+(right-left)/2;
    //         if(list.get(mid) >= num){
    //             right = mid - 1;
    //         }else{
    //             left = mid + 1;
    //         }
    //     }
    //     return left;
    // }

    // public boolean find(int value) {
    //     // write your code here
    //     int left=0,right=list.size()-1;
    //     while(left < right){
    //         int sum = list.get(left) + list.get(right);
    //         if(sum < value){
    //             left++;
    //         }else if(sum > value){
    //             right--;
    //         }else{
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    private Map<Integer,Integer> map = new HashMap<>();
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0)+1);
    }

    public boolean find(int value) {
        // write your code here
        for(int key : map.keySet()){
            if(value-key == key){
                return map.get(key)>1;
            }else if(map.containsKey(value-key)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        两数之和三之数据结构设计170 main = new 两数之和三之数据结构设计170();

        /**
         * 设计并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
         * add -把这个数添加到内部的数据结构。
         * find -是否存在任意一对数字之和等于这个值
         */
        System.out.println(main);
    }
}
