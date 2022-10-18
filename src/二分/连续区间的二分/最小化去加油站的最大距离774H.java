package 二分.连续区间的二分;

/**
 * @Author Cenmo
 * @Date 2022-10-18 21:29
 * @Description
 */
public class 最小化去加油站的最大距离774H {

    public double minmaxGasDist(int[] stations, int k) {
        // Write your code here
        // 最小间隔为0，最大间隔为max-min，此处直接用min=0代替
        int max = stations[0];
        for(int station : stations){
            if(station > max) max = station;
        }
        double left=0,right=(double)max;
        while(right-left > 1e-3){
            double mid = left + (right-left)/2;
            // 能够新增k个加油站，使得最大间距为mid
            if(canReachMid(stations,k,mid)){
                right = mid;
            }else{
                left = mid;
            }

        }
        return left;
    }

    private boolean canReachMid(int[] stations,int k,double dis){
        double gap;
        for(int i=1,n=stations.length;i<n;i++){
            gap = (double)stations[i] - stations[i-1];
            if(gap <= dis){
                continue;
            }else{
                k -= (int)Math.ceil(gap/dis) - 1;
                if(k < 0) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        最小化去加油站的最大距离774H main = new 最小化去加油站的最大距离774H();

        /**
         * 在水平数轴上，我们有加油站：stations[0], stations[1], ..., stations[N-1], 这里N = stations.length。
         *
         * 现在，我们再增加K个加油站，D表示相邻加油站之间的最大距离，这样D就变小了。
         *
         * 返回所有可能值D中最小值。
         */
        System.out.println(Math.round(main.minmaxGasDist(new int[]{3,6,12,19,33,44,67,72,89,95},2))); // 14.00
        System.out.println(main.minmaxGasDist(new int[]{1,2,3,4,5,6,7,8,9,10},9)); // 0.50
        System.out.println(main.minmaxGasDist(new int[]{0,5,8,16,33,61,62,74,83,93},10)); // 6.00
    }
}
