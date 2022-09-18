package 递归;

/**
 * @author Cenmo
 * @Date 2022-03-04 2022-03-04
 */
public class 岛屿数量 {

    int[][] dir = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
    public int solve (char[][] grid) {//visit数组
        // write code here
        int m=grid.length,n=grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int num=0;

//        for(int i=0;i<m;i++)
//            for(int j=0;j<n;j++)
//                visited[i][j] = false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j] == false){//匹配到未访问的岛屿
                    num++;
                    move(grid,visited,i,j);
                }
            }
        }
        return num;
    }

    public void move(char[][] grid,boolean[][] visited,int x,int y){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length){
                if(visited[newx][newy] == false && grid[newx][newy]=='1'){
                    move(grid,visited,newx,newy);
                }
            }
        }
    }

    public int solve2 (char[][] grid) { //改变原矩阵
        int m=grid.length,n=grid[0].length;
        int island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    move(grid,i,j,m,n);
                    island++;
                }
            }
        }
        return island;
    }

    private void move(char[][] grid, int x, int y, int m, int n) {
        grid[x][y] = '0';//已访问
        for(int i=0;i<4;i++){
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if(newx >= 0 && newx < m && newy >=0 && newy < n){
                if(grid[newx][newy] == '1'){
                    move(grid,newx,newy,m,n);
                }
            }
        }
    }

    public static void main(String[] args) {
        岛屿数量 main = new 岛屿数量();

        char[][] grid = new char[][] {{'1','1','0','0','0'},{'0','1','0','1','1'},{'0','0','0','1','1'},{'0','0','0','0','0'},{'0','0','1','1','1'}};
        System.out.println("main.solve(grid) = " + main.solve(grid));
        System.out.println("main.solve2(grid) = " + main.solve2(grid));
    }
}
