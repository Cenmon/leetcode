package 递归.深度优先;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Cenmo
 * @Date 2022-10-10 19:58
 * @Description
 */
public class 水位上升的泳池中游泳778H {

    public int swimInWater(int[][] grid) {
        int n=grid.length,left = 1,right = n*n;
        boolean[][] visited = new boolean[n][n];
        // 最左二分
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canReachFrom(grid,visited,0,0,mid,n)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    visited[i][j] = false;
        }
        return left;
    }
    // 深搜
    private boolean canReachFrom(int[][] grid,boolean[][] visited,int x,int y,int t,int n){
        if(x<0 || x>=n || y<0 || y>=n) return false;
        if(grid[x][y] > t) return false;
        if(visited[x][y]) return false;
        if(x == n-1 && y == n-1) return true;
        visited[x][y] = true;
        return canReachFrom(grid,visited,x,y+1,t,n) || canReachFrom(grid,visited,x,y-1,t,n)
                || canReachFrom(grid,visited,x+1,y,t,n) || canReachFrom(grid,visited,x-1,y,t,n);
    }

    private int[][] direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    private boolean canSwim(int[][] grid,int t){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] <= t) queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[0] == n-1 && pos[1] == n-1) return true;

            visited[pos[0]][pos[1]] = true;
            for(int k=0;k<4;k++){
                int newx = pos[0]+direction[k][0];
                int newy = pos[1]+direction[k][1];
                if(newx<0 || newx>=n || newy<0 || newy>=n){
                    continue;
                }else if(grid[newx][newy]<=t && !visited[newx][newy]){
                    queue.offer(new int[]{newx,newy});
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        水位上升的泳池中游泳778H main = new 水位上升的泳池中游泳778H();


        System.out.println(main.swimInWater(new int[][]{{0,2},{1,3}}));//6
        System.out.println(main.swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));//16
        System.out.println(main.swimInWater(new int[][]{{3,2},{0,1}}));//3
        System.out.println(main.swimInWater(new int[][]{{0}})); // 0
    }
}
