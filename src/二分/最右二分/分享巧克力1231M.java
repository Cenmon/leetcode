package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-19 11:06
 * @Description
 */
public class 分享巧克力1231M {

    public int maximizeSweetness(int[] sweetness, int k) {
        // write your code here
        // 甜度最小为0，最大为数组和
        int left=1,right=0;
        for(int sweet : sweetness) right += sweet;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 分成的k+1个子数组内是否存在一个子数组和大于等于mid，且其他子数组和大于mid
            if(existSubArray(sweetness,k,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
    // k+1个子数组和均大于等于minSum
    private boolean existSubArray(int[] sweetness,int k,int minSum){
        int sum=0,count=0;
        int i=0,n=sweetness.length;
        while(i < n){
            // if(sweetness[j] > minSum) j++; // 元素自身自成一个子数组
            while(i<n && sum < minSum){ // 此处可用窗口来理解，i不动，j往前移
                sum += sweetness[i];
                i++;
            }
            if(sum >= minSum) // 保证i==n时的子数组和同样大于等于minSum
                count++;
            sum = 0;
        }
        return count >= k+1;
    }


    public static void main(String[] args) {
        分享巧克力1231M main = new 分享巧克力1231M();

        /**
         * 你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
         * 你打算和 K 名朋友一起分享这块巧克力，所以你需要将大巧克力切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
         * 为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
         * 请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
         */
        System.out.println(main.maximizeSweetness(new int[]{1,2,3,4,5,6,7,8,9},5)); // 6
        System.out.println(main.maximizeSweetness(new int[]{1,2,2,1,2,2,1,2,2},2)); // 5
        System.out.println(main.maximizeSweetness(new int[]{5,6,7,8,9,1,2,3,4},8)); // 1
    }
}
