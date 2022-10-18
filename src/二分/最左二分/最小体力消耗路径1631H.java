package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-18 22:37
 * @Description
 */
public class 最小体力消耗路径1631H {

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        visited = new boolean[m][n];

        // 体力消耗值的最小值为0，最大值暂为无穷
        int left=0,right=heights[0][0];
        for(int[] arr : heights)
            for(int height : arr)
                if(height > right) right = height;

        while(left <= right){
            int mid = left + (right-left)/2;
            // 能在相邻高度差为mid时从左上角到达右下角
            if(canArrive(heights,0,0,mid,heights[0][0])){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    visited[i][j] = false;
        }
        return left;
    }

    private boolean[][] visited;
    private int m,n;
    private boolean canArrive(int[][] heights,int x,int y,int heightDiff,int lastHegiht){
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(visited[x][y]) return false;
        if(Math.abs(heights[x][y] - lastHegiht) > heightDiff) return false;
        if(x == m-1 && y == n-1) return true;

        visited[x][y] = true;

        return canArrive(heights,x+1,y,heightDiff,heights[x][y]) ||
                canArrive(heights,x-1,y,heightDiff,heights[x][y]) ||
                canArrive(heights,x,y+1,heightDiff,heights[x][y]) ||
                canArrive(heights,x,y-1,heightDiff,heights[x][y]);
    }


    public static void main(String[] args) {
        最小体力消耗路径1631H main = new 最小体力消耗路径1631H();

        /**
         * 给你一个二维 m*n 的地图 heights,heights[i][j]表示高度
         * 最开始位于(0,0)位置，目标是(m-1,n-1),每次可以上下左右移动，你想要找到耗费 体力 最小的一条路径
         * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
         * 请你返回从左上角走到右下角的最小 体力消耗值 。
         */
        System.out.println(main.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}})); // 2
        System.out.println(main.minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}})); // 1
        System.out.println(main.minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}})); // 0
    }
}
