package 双指针.模拟.扫描区间.区间加法;

import Utils.ArrayUtils;

/**
 * @Author Cenmo
 * @Date 2022-09-16 20:19
 * @Description
 */
public class 航班预订统计1109M {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] book : bookings){
            ans[ book[0]-1 ] += book[2];
            if(book[1] < n)
                ans[ book[1] ] -= book[2];
        }
        for(int i=1;i<n;i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        航班预订统计1109M main = new 航班预订统计1109M();

        /**
         * 给定n个航班的预定表bookings, bookings[i] = [from, to, seats] 
         * 表示从 from 到 to （包含 from 和 to ）的 每个航班 上预订了 seat 个座位。
         *  请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数
         */
        ArrayUtils.print(main.corpFlightBookings(new int[][]{{1,2,10},{2,3,5},{2,5,25}},5)); // [10,55,45,25,25]
        ArrayUtils.print(main.corpFlightBookings(new int[][]{{1,2,10},{2,2,5}},2)); // [10,25]
    }
}
