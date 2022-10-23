package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-21 15:43
 * @Description
 */
public class 准时到达的列车最小时速1870M {

    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length-1) return -1;
        // 车速最小为1，最大为10e7
        // 最后一个站点dist[i]<=10e5,hours最多两位小数，hours=0.01时车速为10e7
        int left=1,right=10000000;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 是否能在车速为mid时准时到达办公室
            if(ArriveOnTime(dist,hour,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean ArriveOnTime(int[] dist,double hour,double speed){
        double time=0.0;
        for(int i=dist.length-2;i>=0;i--){
            time += Math.ceil(dist[i]/speed);
        }
        time += dist[dist.length-1]/speed;
        return time <= hour;
    }


    public static void main(String[] args) {
        准时到达的列车最小时速1870M main = new 准时到达的列车最小时速1870M();

        /**
         * 给定到达办公室需要乘坐的n辆车对应整数数组dist，dist[i]表示n俩车需要行驶的距离以及总时间hour
         * 每乘坐完一辆车后都需要等到整数时间下一辆车才发车
         * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
         * 生成的测试用例保证答案不超过 107 ，且 hour 的 小数点后最多存在两位数字
         */
        System.out.println(main.minSpeedOnTime(new int[]{1,3,2},6));//1
        System.out.println(main.minSpeedOnTime(new int[]{1,3,2},2.7));//3
        System.out.println(main.minSpeedOnTime(new int[]{1,3,2},1.9));//-1
        System.out.println(main.minSpeedOnTime(new int[]{1,1,100000},2.01));//10000000
        System.out.println(main.minSpeedOnTime(new int[]{1,1},1.0));//-1
        System.out.println(main.minSpeedOnTime(new int[]{5,3,4,6,2,2,7},10.92));//4
    }
}
