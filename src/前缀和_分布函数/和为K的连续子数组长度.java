package 前缀和_分布函数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cenmo
 * @Date 2022-03-17 2022-03-17
 */
public class 和为K的连续子数组长度 {

    // 和为k的连续数组表示为：Sn-Si = k (i在n的前面)，有Si = Sn-k
    // 此处求最大长度，即n-i
    public int maxlenEqualK (int[] arr, int k) {
        Map<Integer,Integer> sumIndex = new HashMap<>();
        sumIndex.put(0,-1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if( sumIndex.containsKey(sum-k) ){
                res = Math.max( res, i-sumIndex.get(sum-k) );
            }
            if(!sumIndex.containsKey(sum)){ // 只记录sum第一次出现的下标位置，保证最长
                sumIndex.put(sum,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        和为K的连续子数组长度 main = new 和为K的连续子数组长度();

        System.out.println(main.maxlenEqualK(new int[] {1,-2,1,1,1} ,0)); // 3 = [1,-2,1]
        System.out.println(main.maxlenEqualK(new int[] {0,1,2,3} ,3)); // 3 = [0,1,2]
    }
}
