package 贪心;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Cenmo
 * @Date 2022-09-12 20:32
 * @Description
 */
public class 跳跃游戏三1306M_DFS {

    public boolean canReach(int[] arr, int start) { // BFS
        if(arr[start] == 0) return true;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int idx = queue.poll();

            int left = idx-arr[idx];
            if(left >= 0 && !visited[left]){
                if(arr[left] == 0) return true;
                queue.offer(left);
                visited[left] = true;
            }

            int right = idx+arr[idx];
            if(right < n && !visited[right]){
                if(arr[right] == 0) return true;
                queue.offer(right);
                visited[right] = true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        跳跃游戏三1306M_DFS main = new 跳跃游戏三1306M_DFS();

        /**
         * 给定非负整数数组arr，你最开始位于该数组的起始下标 start 处。
         * 当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
         * 返回是否能够跳到对应元素值为 0 的 任一 下标处。
         * 注意，不管是什么情况下，你都无法跳到数组之外。
         */
        System.out.println(main.canReach(new int[]{4,2,3,0,3,1,2},5));
        System.out.println(main.canReach(new int[]{4,2,3,0,3,1,2},0));
        System.out.println(main.canReach(new int[]{3,0,2,1,2},2));
    }
}
