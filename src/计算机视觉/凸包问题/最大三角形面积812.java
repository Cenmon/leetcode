package 计算机视觉.凸包问题;

/**
 * @author Cenmo
 * @Date 2022-07-22 2022-07-22
 */
public class 最大三角形面积812 {
    /**
     * 已知n个二维坐标，求各个点围成的图像面积
     * 公式：S = 1/2 * | 第一个点与第二个点的叉积 + 第二个点与第三个点的叉积 + .... + 第n个点与第一个点的叉积 |
     * @param mat : 二维坐标点集
     */
    public double caculateArea(int[][] mat){
        double area = 0;
        int n=mat.length;
        for(int i=0;i<n;i++){
            area += mat[i][0]*mat[(i+1)%n][1] - mat[i][1]*mat[(i+1)%n][0];
        }
        return 0.5 * Math.abs(area);
    }

    /**
     * 法二：先算凸包，在用凸包的点计算最大三角形面积
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    maxArea = Math.max(maxArea,Math.abs(points[i][0]*points[j][1]+points[j][0]*points[k][1]+points[k][0]*points[i][1]-points[i][1]*points[j][0]-points[j][1]*points[k][0]-points[k][1]*points[i][0])/2.0);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        最大三角形面积812 main = new 最大三角形面积812();

        /**
         * 给出n个二维点坐标，计算围成的图形面积
         */
        System.out.println( main.caculateArea(new int[][]{{0,0},{0,2},{2,0}})); // 2.0

        /**
         * 给出二维坐标点，选择三个坐标，其围出的三角形面积最大
         */
        System.out.println(main.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}})); // 2.0
    }
}
