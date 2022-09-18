package 双指针.模拟.移位.首尾移位;

import Utils.ArrayUtils;

import java.util.Arrays;

public class 移动石子直到连续二1040M {

    // @Cenmo:两端移动问题
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        // 确定最多移动次数：二人转移动方式确保移动次数最多
        // 选择最左端移动到右端保证最右端两个石头相邻，而后交替填坑，保证移动次数最多
        // 最后从最左端移动到右端 或最右端移动到最左端使其相邻中的填坑次数选最大值
        int n=stones.length;
        // stones[j]-stones[i]+1：第i块石头到第j块石头的总坑数
        // j-i+1 : 石头总数
        int maxRemove = Math.max(stones[n-1]-stones[1]+1-(n-1),stones[n-2]-stones[0]+1-(n-1));

        // 确定一个石头最密集的区域，往该区域中移动石头
        // 窗口大小固定为n，寻找最小移动次数
        int minRemove=Integer.MAX_VALUE;
        int j=0,gap=0;
        for(int i=0;i<n;i++){
            // 寻找总坑位大于或等于窗口n,即[i,j]范围保证能够存放所有石头
            while(j<n && stones[j]-stones[i]+1 < n) j++;
            if(j == n) break;

            if(stones[j]-stones[i]+1 == n){ // [i,j]坑位数等于n，其他石头依次放入空缺即可
                System.out.println(j-i+1);
                gap = n - j + i - 1; // n-(j-i+1):i-j石头之间的空缺数即移动次数
            }else if(j-i+1 == n){ // 坑位数大于窗口大小n，但石头总数为n,即窗口内的空位仅剩最右边一个
                gap = 2;
            }else{
                // [i,j]坑位数大于窗口大小，石头总数小于n，即[i,j]之外还有石头
                // 先把最右端石头移到窗口末端，即stones[i]+n-1，再依次移到窗口内的空缺，移动次数为1+n-(j-i+1)
                gap = n - j + i; // 1+n-(j-i+1)
            }

            minRemove = Math.min(minRemove,gap);
        }

        return new int[]{minRemove,maxRemove};
    }


    public static void main(String[] args) {
        移动石子直到连续二1040M main = new 移动石子直到连续二1040M();

        /**
         * 给定数组stones，表示第i块石头所在位置，每次只能移动最左端或最右端的石头，且移动后的位置不能是最左或最右
         * 返回将所有石头连续的最小移动次数和最大移动次数
         */
        ArrayUtils.print(main.numMovesStonesII(new int[]{7,4,9})); // 1,2
        ArrayUtils.print(main.numMovesStonesII(new int[]{6,5,4,3,10})); // 2,3
        ArrayUtils.print(main.numMovesStonesII(new int[]{100,101,104,102,103})); // 0,0
    }
}
