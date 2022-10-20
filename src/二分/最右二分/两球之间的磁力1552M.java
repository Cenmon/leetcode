package 二分.最右二分;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-20 20:14
 * @Description
 */
public class 两球之间的磁力1552M {

    public int maxDistance(int[] position, int m) {
        // 磁力（距离）的最小值为1，最大值为max(position)
        Arrays.sort(position);
        int left = 1,right = position[position.length-1]-position[0];
        while(left <= right){
            // 设最小距离为mid，求相邻距离为mid的最大mid
            int mid = left + (right-left)/2;
            // 能否使得相邻小球距离最小为mid
            if(distanceGreater(position,m,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean distanceGreater(int[] position,int m,int minDis){
        int i=0,j=0,n=position.length;
        int count=1;// 下标0放一个球，若0不放求，相当于所有位置减一，必定有某对球的距离减小
        while(i < n){
            while(j<n && position[j]-position[i] < minDis){
                j++;
            }

            if(j == n) {
                break;
            }else{
                i=j;
                count++;
            }
            if(count == m) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        两球之间的磁力1552M main = new 两球之间的磁力1552M();

        /**
         * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，
         * 它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，
         * Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
         *
         * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
         *
         * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
         */
        System.out.println(main.maxDistance(new int[]{1,2,3,4,7},3)); // 3 将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3
        System.out.println(main.maxDistance(new int[]{5,4,3,2,1,1000000000},2)); // 999999999
    }
}
