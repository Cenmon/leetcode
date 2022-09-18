package Basic;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-09-11 20:18
 * @Description 十进制转二进制
 */
public class 十进制转k进制 {

    public List<Integer> DecimalToK(int n,int k){
        List<Integer> arr = new ArrayList<>();
        while(n > 0){
            arr.add( n % k);
            n /= k;
        }
        Collections.reverse(arr);
        return arr;
    }


    public static void main(String[] args) {
        十进制转k进制 main = new 十进制转k进制();

        JavaUtils.print(main.DecimalToK(17,2)); // 10001
        JavaUtils.print(main.DecimalToK(9,3)); // 100
        JavaUtils.print(main.DecimalToK(38,3)); // 1102
    }
}
