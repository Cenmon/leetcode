package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-18 21:52
 * @Description
 */
public class 在D天内送达包裹的能力1011H {

    public int shipWithinDays(int[] weights, int days) {
        // 运输能力最低为0，最高为数组和
        int left=0,right=0;
        for(int weight : weights)
            right += weight;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 能否在最大运载能力为mid时在days天内完成运输
            if(canConveyPackage(weights,days,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    // 贪心运输
    private boolean canConveyPackage(int[] weights,int days,int maxWeight){
        int count=0,sum=0;
        int i=0,j=0,n=weights.length;
        while(i<n){
            if(weights[j] > maxWeight) return false;

            while(j<n && sum+weights[j] <= maxWeight){
                sum += weights[j];
                j++;
            }
            count++;
            i = j;
            sum = 0;
        }
        return count <= days;
    }


    public static void main(String[] args) {
        在D天内送达包裹的能力1011H main = new 在D天内送达包裹的能力1011H();

        /**
         *传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
         *
         * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。
         * 我们装载的重量不会超过船的最大运载重量。
         *
         * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
         */
        System.out.println(main.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5)); // 15
        System.out.println(main.shipWithinDays(new int[]{3,2,2,4,1,4},3)); // 6
        System.out.println(main.shipWithinDays(new int[]{1,2,3,1,1},4)); // 3
    }
}
