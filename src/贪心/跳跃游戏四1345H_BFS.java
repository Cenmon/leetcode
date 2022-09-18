package 贪心;

import java.util.*;

/**
 * @Author Cenmo
 * @Date 2022-09-13 9:57
 * @Description
 */
public class 跳跃游戏四1345H_BFS {

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int n = arr.length,ans=0;

        for(int i=0;i<n;i++){
            List<Integer> list = map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        // System.out.println(map.toString());

        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                int idx = queue.poll();
                if(idx == n-1) return ans;

                if(idx-1 >=0 && !visited[idx-1]) {
                    queue.offer(idx-1);
                    visited[idx-1] = true;
                }
                if(idx+1 <n && !visited[idx+1]) {
                    queue.offer(idx+1);
                    visited[idx+1] = true;
                }
                if(!map.containsKey(arr[idx])) continue;
                for(Integer id : map.get(arr[idx])){
                    if(!visited[id]){
                        queue.offer(id);
                        visited[id] = true;
                    }
                }
                map.remove(arr[idx]);
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        跳跃游戏四1345H_BFS main = new 跳跃游戏四1345H_BFS();

        /**
         * 给定数组arr,起始位置为下标0，每次可跳到i+1,i-1,或与arr[i]值相同的任意位置，保证不嫩越界
         * 返回到达数组最后一个元素的下标处所需的 最少操作次数 。
         */
        System.out.println(main.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404})); // 3
        System.out.println(main.minJumps(new int[]{7})); // 0
        System.out.println(main.minJumps(new int[]{7,6,9,6,9,6,9,7})); // 1
        System.out.println(main.minJumps(new int[]{7,7,2,1,7,7,7,3,4,1})); // 3 path={0-4-3-9}
    }
}
