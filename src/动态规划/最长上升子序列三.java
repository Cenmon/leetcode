package 动态规划;

import Utils.ArrayUtils;

import java.util.ArrayList;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 * https://www.youtube.com/watch?v=DhVLOS44yoY
 */
public class 最长上升子序列三 {

    public int[] LIS (int[] arr) { // 动态规划
        // write code here
        int length = arr.length;
        int[][] dp = new int[length][2];

        int max=1,pre=0;
        for(int i=0;i<length;i++){
            dp[i][0] = 1;
            dp[i][1] = -1;
            for(int j=0;j<i;j++){
                if( arr[i] > arr[j]){
//                  dp[n] = max(dp[0],dp[1]....dp[n-2],dp[n-1])+1 = max(dp[0]+1,dp[1]+1....dp[n-2]+1,dp[n-1]+1)
                    dp[i][0] = Math.max(dp[i][0],dp[j][0]);//最值取法，dp[i]记录前序最大值
                    dp[i][1] = j;
                }
            }
            dp[i][0] = dp[i][0] + 1;
//            max = Math.max(dp[0],dp[1]....dp[n-2],dp[n-1],dp[n])
            if(dp[i][0] > max){//最值取法max
                max = dp[i][0];
                pre = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(pre != -1){
            System.out.println("pre = " + pre);
            list.add( arr[pre] );
            pre = dp[pre][1];
        }

        int[] res = new int[list.size()];
        for(int i=0,j=list.size()-1;i<list.size();i++,j--){
            res[j] = list.get(i);
        }
        return res;
    }

    public int[] LIS2 (int[] arr) {
        // write code here
        // arr[i]记录长度为i的最长上升子序列的最后一个元素
        int n = arr.length;
        int[] lis = new int[n];
        int len = 0;
        int[] track = new int[n+1];

        /**
         * 遍历数组，维护排队数组lis，若大于队尾元素，则排在最后，若小于队尾元素，则取代队中某个元素
         * 遍历的每个元素最后在排队数组lis的最终位置pos，即长度为pos+1的上升子序列最后一个元素
         * 单调队列的变种
         */
        for(int i=0;i<n;i++){
            int pos = biSearch(lis,0,len,arr[i]);

            lis[pos] = arr[i];
            track[i] = pos+1; // 溯源：arr[i]是长度为pos+1的最长子序列的最后一个元素
            if(pos >= len) { // 若pos指向末尾，则len自增
                len++;
            }
        }
        int[] res = new int[len];
        for(int i=n-1;i>=0;i--) {
            if (track[i] == len) {
                res[len - 1] = arr[i];
                len--;
            }
        }
        return res;
    }

    public int biSearch(int[] arr,int start,int end,int target){
        int low=start,high=end-1;
        while(low <= high){
            int mid = low + ((high - low) >> 2); // 按位移动运算符优先级低于算数运算符
            if(target < arr[mid]) high = mid - 1;
            else if(target > arr[mid]) low = mid + 1;
            else return mid;
        }
        return low; // 升序中返回元素第几小
    }

    public static void main(String[] args) {
        最长上升子序列三 main = new 最长上升子序列三();

        int[] ints = {2, 1, 5, 3, 6, 4, 8, 9, 7}; // 1,3,4,8,9
//        int[] ints = {1,2,8,6,4}; // 1,2,4
        ArrayUtils.print(ints);
        int[] lis = main.LIS2(ints);
        ArrayUtils.print(lis);
    }
}
