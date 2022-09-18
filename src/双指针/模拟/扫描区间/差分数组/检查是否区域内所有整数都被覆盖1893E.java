package 双指针.模拟.扫描区间.差分数组;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-09-16 20:08
 * @Description
 */
public class 检查是否区域内所有整数都被覆盖1893E {

    public boolean isCovered2(int[][] ranges, int left, int right) { // 是否存在区间交集
        Arrays.sort(ranges,(o1, o2)->o1[0]-o2[0]);
        for(int[] range : ranges){
            if(range[0] <= left && left <= range[1]) {
                left = range[1]+1;
            }
            if(range[0] <= right && right <= range[1]){
                right = range[0]-1;
            }
        }
        return left > right;
    }

    public boolean isCovered(int[][] ranges, int left, int right) { // 差分数组
        //  数据考察范围在1~50内
        int[] diff = new int[52];
        for(int[] range : ranges){
            diff[ range[0] ] += 1;
            diff[ range[1]+1 ] -= 1;
        }
        int sum = 0;
        for(int i=1;i<51;i++){
            sum += diff[i];
            if(left<=i && i<=right && sum == 0){ // 遍历[left,right]内的每个元素，若访问次数为0
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        检查是否区域内所有整数都被覆盖1893E main = new 检查是否区域内所有整数都被覆盖1893E();

        /**
         * 给定区间数组ranges，和特定区间[left,right],
         * 返回区间数组内的区间是否能够覆盖[left,right]的所有元素
         */
        System.out.println(main.isCovered(new int[][]{{1,2},{3,4},{5,6}},2,5)); // true
        System.out.println(main.isCovered(new int[][]{{2,2},{3,3},{1,1}},1,3)); // true
        System.out.println(main.isCovered(new int[][]{{1,10},{10,20}},21,21)); // false

    }
}
