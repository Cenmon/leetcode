package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-20 21:54
 * @Description
 */
public class 销售价值减少的颜色球1648H {

    public int maxProfit(int[] inventory, int orders) {
        // 最后一次取求的价值最小为1，最大为max(inventory)
        // Arrays.sort(inventory);
        int left=1,right=inventory[0];
        for(int num : inventory){
            if(num > right) right = num;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            // 是否存在最后一次取球的价值为mid,且最后一次取球价值越大越好
            if(check(inventory,orders,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right);
        long x = right;
        long ans = 0,M = 1000000007;
        for(int ball : inventory){
            if(ball > x){
                ans = (ans + (x+1+ball)*(ball-x)/2) % M;
                orders -= ball-x;
            }
        }
        if(orders > 0) ans = (ans+x*orders) % M;
        return (int)ans;
    }

    private boolean check(int[] inventory,int orders,int value){
        int count = 0;
        for(int ball : inventory){
            if(ball > value){
                count += ball-value+1;
            }
        }
        return count >= orders;
    }


    public static void main(String[] args) {
        销售价值减少的颜色球1648H main = new 销售价值减少的颜色球1648H();


        System.out.println(main.maxProfit(new int[]{2,5},4));//14
        System.out.println(main.maxProfit(new int[]{3,5},6));//19
        System.out.println(main.maxProfit(new int[]{1,2},1));//2
        System.out.println(main.maxProfit(new int[]{1000000000},1000000000));//21
        System.out.println(main.maxProfit(new int[]{701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037},598226067));//
        System.out.println(main.maxProfit(new int[]{773160767},252264991));//
        System.out.println(main.maxProfit(new int[]{497978859,167261111,483575207,591815159},836556809));//
    }
}
