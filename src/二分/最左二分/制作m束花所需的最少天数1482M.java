package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-19 17:29
 * @Description
 */
public class 制作m束花所需的最少天数1482M {

    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k) return -1; // 保证花数足够
        // 等待的天数最少为0，最大为max(bloomDay)
        int left=1,right=bloomDay[0];
        for(int day : bloomDay){
            if(day > right) right = day;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            // 在第mid天是否能够获取m束话
            if(canPickMFlowers(bloomDay,m,k,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    // 在第mid天是否能够获取m束话
    private boolean canPickMFlowers(int[] bloomDay,int m,int k,int day){
        int count=0,pick=0;
        int i=0,n=bloomDay.length;
        while(i < n){
            pick=0;
            while(i<n && bloomDay[i] <= day){ // 连续的盛开时间小于等于day的花数
                pick++;
                i++;
            }
            count += pick / k;
            i++;
        }
        return count >= m;
    }


    public static void main(String[] args) {
        制作m束花所需的最少天数1482M main = new 制作m束花所需的最少天数1482M();

        /**
         * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
         *
         * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
         *
         * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
         *
         * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
         */
        System.out.println(main.minDays(new int[]{1,10,3,10,2},3,1));//3
        System.out.println(main.minDays(new int[]{1,10,3,10,2},3,2));//-1
        System.out.println(main.minDays(new int[]{7,7,7,7,12,7,7},2,3));//12
        System.out.println(main.minDays(new int[]{1000000000,1000000000},1,1));//1000000000
        System.out.println(main.minDays(new int[]{1,10,2,9,3,8,4,7,5,6},4,2));//9
    }
}
