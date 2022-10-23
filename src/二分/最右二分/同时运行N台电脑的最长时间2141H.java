package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-23 15:38
 * @Description
 */
public class 同时运行N台电脑的最长时间2141H {

    public long maxRunTime(int n, int[] batteries) {
        // 同时运行的时间最小为0，最大为sum(batteries)/n;
        long left = 0,right = 0;
        for(int battery : batteries){
            right += battery;
        }
        right /= n;
        while(left <= right){
            long mid = left+(right-left)/2;
            // 能否让n台电脑同时运行mid分钟
            if(canOperateN(n,batteries,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean canOperateN(int n,int[] batteries,long minute){
        long sum = 0;
        for(int battery : batteries){
            if(battery < minute){
                sum += battery;//小于minute的电池合作铺设，且同一时刻只能出现一类电池
            }else{
                sum += minute; //大于限定minute的电池直接铺
            }
        }
        return sum >= n*minute;
    }


    public static void main(String[] args) {
        同时运行N台电脑的最长时间2141H main = new 同时运行N台电脑的最长时间2141H();

        /**
         * 给定电脑数n以及m个电池数组batteries,batteries[i]表示能够使电脑运行的时间
         * 每个电池同一时间只能给一台电脑用，但可以在任意时刻拆下组装到其他电脑
         * 返回能够让n台电脑同时运行的最长时间
         */
        System.out.println(main.maxRunTime(2,new int[]{3,3,3})); // 4
        System.out.println(main.maxRunTime(2,new int[]{1,1,1,1})); // 2
        System.out.println(main.maxRunTime(4,new int[]{3,4,5,6})); // 3
    }
}
