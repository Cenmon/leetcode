package 贪心;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-25 2022-03-25
 */
public class 分糖果二 {

    public int[] distributeCandier(int candy,int num_people){
        int[] solution = new int[num_people];

        int i=0;
        int curNum=1;
        while(candy > 0){
            solution[i%num_people] += curNum;
            candy -= curNum;

            if(candy < 0 ){ // 最后一个同学
                solution[i%num_people] += candy;
            }

            i++; // 分给第i个同学
            curNum++; // 下一个同学分的糖果加一
        }
        return solution;
    }


    /**
     * 给出总糖果数，n个人，第一个分1个，第二个分两个，循环分发，最后多余的则发给最后一个同学
     * 输出每个人分发糖果总数
     */
    public static void main(String[] args) {
        分糖果二 main = new 分糖果二();
        ArrayUtils arrayUtils = new ArrayUtils();

        arrayUtils.print(main.distributeCandier(10,3)); // [5,2,3]:[1,4]、[2]、[3]
        arrayUtils.print(main.distributeCandier(10,4)); // [1,2,3,4]:[1]、[2]、[3]、[4]
    }
}
