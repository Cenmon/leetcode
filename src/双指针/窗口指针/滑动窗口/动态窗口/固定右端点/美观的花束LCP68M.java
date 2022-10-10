package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-10 16:04
 * @Description
 */
public class 美观的花束LCP68M {

    public int beautifulBouquet(int[] flowers, int cnt) {
        int i=0;
        long ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int j=0,n=flowers.length;j<n;j++){
            map.put(flowers[j],map.getOrDefault(flowers[j],0)+1);
            while(map.get(flowers[j]) > cnt) {
                map.put(flowers[i],map.get(flowers[i])-1);
                i++;
            }
            ans += j-i+1;
        }
        return (int)(ans%1000000007);
    }


    public static void main(String[] args) {
        美观的花束LCP68M main = new 美观的花束LCP68M();

        /**
         * 给定数组flowers记录位置i摆放的鲜花品种编号，
         * 现选择一段区间栽种鲜花，若区间内某个品种的鲜花数量不超过cnt，则认为该品种的鲜花是美观的
         * 返回在这一排鲜花中，共有多少种可选择的区间，使得插花是「美观的」,答案膜除1000000007
         */
        System.out.println(main.beautifulBouquet(new int[]{1,2,3,2},1)); // 8
        System.out.println(main.beautifulBouquet(new int[]{5,3,3,3},2)); // 8
    }
}
