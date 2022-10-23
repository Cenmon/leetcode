package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-21 21:46
 * @Description
 */
public class 分配给商店的最多商品的最小值2064M {

    public int minimizedMaximum(int n, int[] quantities) {
        // 每家商店分配的商品数最小为1，最大为max(quantities)
        int left=1,right=quantities[0];
        for(int quantity : quantities){
            if(quantity > right) right = quantity;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            // 每家最多分mid需要的商店数范围，[min,max]
            long max = 0,min = 0;
            for(int quantity : quantities){
                max += quantity-mid+1;
                min += (quantity+mid-1)/mid;
            }
            if(min > n){
                left = mid + 1;// 减小min，即增大mid
            }else if(max < n){
                right = mid - 1;// 增大max,即减小mid
            }else{
                right = mid - 1; // 试探更小商品数
            }
        }
        return left;
    }


    public static void main(String[] args) {
        分配给商店的最多商品的最小值2064M main = new 分配给商店的最多商品的最小值2064M();

        /**
         * 给定商店总数n以及m种商品的数组quantities，quantities[i]表示i类商品的数量
         * 现给每家商店分配商品，要求每家商品最多分配一种商品
         * 且应该使得所有商店分配的商品数的最大值最小
         * 返回这个最小值
         */
        System.out.println(main.minimizedMaximum(6,new int[]{11,6}));//3
        System.out.println(main.minimizedMaximum(7,new int[]{15,10,10}));//5
        System.out.println(main.minimizedMaximum(1,new int[]{100000}));//100000
    }
}
