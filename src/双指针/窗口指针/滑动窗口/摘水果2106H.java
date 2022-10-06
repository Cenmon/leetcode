package 双指针.窗口指针.滑动窗口;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-06 19:03
 * @Description
 */
public class 摘水果2106H {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] pos = new int[n];
        int[] presum = new int[n];
        pos[0] = fruits[0][0];
        presum[0] = fruits[0][1];
        for(int i=1;i<n;i++){
            pos[i] = fruits[i][0];
            presum[i] = presum[i-1]+fruits[i][1];
        }

        // System.out.println(Arrays.toString(presum));
        int mid = Arrays.binarySearch(pos,startPos);
        mid = mid >= 0 ? mid : -mid-1;

        int ans=0;
        for(int i=0,j=mid;j<n;j++){ // 第一个循环，i指向第一个fruit，j指向startPos
            while(pos[i]<=startPos && 2*(pos[j]-startPos)+(startPos-pos[i]) > k){
                i++;
            }
            if(pos[i]<=startPos || pos[j] - startPos <= k)
                ans = Math.max(ans,presum[j] - (i>0?presum[i-1]:0));
        }
        if(mid<n && pos[mid] == startPos) mid++; // 第二个循环时，i指向startPos,j指向最后一个fruit
        for(int i=mid-1,j=n-1;i>=0;i--){
            while(pos[j]>=startPos && 2*(startPos - pos[i])+(pos[j]-startPos) > k){
                j--;
            }
            if(pos[j]>=startPos || startPos - pos[i] <= k)
                ans = Math.max(ans,presum[j] - (i>0?presum[i-1]:0));
        }
        return ans;
    }


    public static void main(String[] args) {
        摘水果2106H main = new 摘水果2106H();

        /**
         * 给定二维数组fruits，起始位置startPos,可移动步数k，
         * 其中fruits[i]表示水果位置和水果数量，二维数组fruits已按照水果位置排序
         * 先从起始位置startPos移动k步，可前移或后移，移动到fruits[i]时则收获fruits[i][1]个水果
         * 返回k步内获得的最多水果数量
         */

        System.out.println(main.maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}},5,4));
        //9
        System.out.println(main.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}},5,4));
        //14
        System.out.println(main.maxTotalFruits(new int[][]{{0,3},{6,4},{8,5}},3,2));
        //0
        System.out.println(main.maxTotalFruits(new int[][]{{200000,10000}},200000,200000));
        //10000
        System.out.println(main.maxTotalFruits(new int[][]{{0,10},{1,6},{2,4},{8,10},{9,5},{13,3},{14,3},{23,4},{28,5},{29,7},{30,6},{32,2},{33,8},{36,4},{40,9}},0,23));
        //45
        System.out.println(main.maxTotalFruits(new int[][]{{0,10000}},200000,200000));
        //10000
    }
}
