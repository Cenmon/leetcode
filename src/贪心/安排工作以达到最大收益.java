package 贪心;

import java.awt.*;
import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-03-27 2022-03-27
 */
public class 安排工作以达到最大收益 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] ps = new Point[n];
        for(int i=0;i<n;i++)
            ps[i] = new Point(difficulty[i],profit[i]);
        Arrays.sort(ps,(p1, p2)->p1.x-p2.x);
        Arrays.sort(worker);

        int j=0,ans=0,bestProfit=0;
        for(int i=0;i<worker.length;i++){
            while(j<n && ps[j].x <= worker[i]){
                bestProfit = Math.max(bestProfit,ps[j].y);
                j++;
            }
            ans += bestProfit;
        }
        return ans;
    }

    public static void main(String[] args) {
        安排工作以达到最大收益 main = new 安排工作以达到最大收益();

        int[] difficulty = {68,35,52,47,86};
        int[] profits = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};

        System.out.println(main.maxProfitAssignment(difficulty,profits,worker));
    }
}
