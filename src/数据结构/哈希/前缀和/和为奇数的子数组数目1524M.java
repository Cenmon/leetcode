package 数据结构.哈希.前缀和;

/**
 * @Author Cenmo
 * @Date 2022-10-30 17:04
 * @Description
 */
public class 和为奇数的子数组数目1524M {

    public int numOfSubarrays(int[] arr) {
        // presum[j]-presum[i]=odd -> presum[j] = odd+presum[i]
        long odd=0,even=1; // 0为偶数
        long sum = 0,ans = 0;
        for(int num : arr){
            sum += num;

            if(sum % 2 == 0){ // 当presum[j]为偶数时，由于odd必为奇数，则presum[i]要为奇数
                ans += odd;
                even++;
            }else{// 当presum[j]为奇数时，由于odd必为奇数，则presum[i]要为偶数
                ans += even;
                odd++;
            }
        }
        return (int)(ans%1000000007);
    }


    public static void main(String[] args) {
        和为奇数的子数组数目1524M main = new 和为奇数的子数组数目1524M();

        /**
         * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
         *
         * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
         */
        System.out.println(main.numOfSubarrays(new int[]{1,3,5}));//4
        System.out.println(main.numOfSubarrays(new int[]{2,4,6}));//0
        System.out.println(main.numOfSubarrays(new int[]{1,2,3,4,5,6,7}));//16
    }
}
