package 双指针.模拟.移位.首尾移位;

import Utils.ArrayUtils;

public class 移动石子直到连续1033M {

    // @Cenmo:两端移动问题
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a,Math.min(b,c));
        int z = Math.max(a,Math.max(b,c));
        int y = a+b+c-x-z;
        int maxRemove = z-x+1-3; // [x,y]和[y,z]之间的所有空缺
        int minRemove;
        if(z-x == 2){ // 三个石头已连续
            minRemove = 0;
        }else if(y-x <= 2 || z-y <= 2){ // 三个石头中有两个连续或者有两个之间的空缺为1
            minRemove = 1;
        }else{ // 三个石头相邻两个的空缺均大于1
            minRemove = 2;
        }
        return new int[]{minRemove,maxRemove};
    }


    public static void main(String[] args) {
        移动石子直到连续1033M main = new 移动石子直到连续1033M();
        /**
         * 给定三块石头的位置a,b,c，每次只能移动最左端或最右端的石头，放在既定范围内任一位置
         * 返回三块石头连续的最小移动次数和最大移动次数
         */
        ArrayUtils.print(main.numMovesStones(1,2,5)); // 1,2
        ArrayUtils.print(main.numMovesStones(4,3,2)); // 0,0
        ArrayUtils.print(main.numMovesStones(3,5,1)); // 1,2
        ArrayUtils.print(main.numMovesStones(1,4,5)); // 1,2
    }
}
