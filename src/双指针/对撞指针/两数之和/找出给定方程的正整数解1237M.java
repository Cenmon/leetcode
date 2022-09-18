package 双指针.对撞指针.两数之和;

import Interface.CustomFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找出给定方程的正整数解1237M {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int x=1,y=z;
        while(x<=z && y>=1){
            int res = customfunction.f(x,y);
            if(res < z) x++;
            else if(res > z) y--;
            else {
                ans.add(Arrays.asList(x,y));
                x++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        找出给定方程的正整数解1237M main = new 找出给定方程的正整数解1237M();

        /**
         * 给定一个计算方法包装类CustomFunction以及目标值z，计算方法统一设置为f(x,y),求想x,y在[1,z]范围内f(x,y)=z的所有可能
         * f(x,y)计算方法未知，但包括加减乘除等九种方式
         * 已知f(x,y)<f(x+1,y),f(x,y)<f(x,y+1),即满足值的单调性
         */
        System.out.println(main);
    }
}
