package Basic;

/**
 * @Author Cenmo
 * @Date 2022-08-24 2022-08-24
 * @Description
 */
public class 向量叉积 {

    /**
     * 向量叉积的应用：判断目标向量在当前向量方向的逆时针还是顺时针，服从右手法则
     * 逆时针叉积为正，顺时针叉积为负
     */
    public int cross(int[] p, int[] q, int[] r) {
        // 向量pq与向量qr的叉积(行列式拆开)
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }


    public static void main(String[] args) {
        向量叉积 main = new 向量叉积();

        System.out.println(main);
    }
}
