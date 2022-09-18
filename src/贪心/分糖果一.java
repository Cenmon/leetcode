package 贪心;

import java.util.HashSet;

/**
 * @author Cenmo
 * @Date 2022-03-25 2022-03-25
 */
public class 分糖果一 {
    public int distributeCandier(int[] candies){
        HashSet<Integer> set = new HashSet<>();
        for(int candy : candies)
            set.add(candy);
        /**
         * 若种类数set.size()低于一半，则把所有不同种类的糖果都分给妹妹，即size()
         * 若种类数set.size()超过一半，则妹妹分到的最多种类数是一半，即length/2
         */
        return Math.min(set.size(),candies.length/2);
    }

    /**
     * 给出糖果所属种类，糖果是偶数个，弟弟妹妹平分，要求妹妹所得糖果所属种类数最多
     */
    public static void main(String[] args) {
        分糖果一 main = new 分糖果一();
        System.out.println(main.distributeCandier(new int[] {1,1,2,2,3,3})); // 3,弟弟妹妹都分到[1,2,3]号糖果
        System.out.println(main.distributeCandier(new int[] {1,1,2,3}));
        // 2 妹妹分[2,3]号糖果，弟弟分[1,1]号糖果，妹妹种类数最多
    }
}
