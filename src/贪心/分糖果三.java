package 贪心;

/**
 * @author Cenmo
 * @Date 2022-03-25 2022-03-25
 */
public class 分糖果三 {

    public int distributeCandier(int[] arr){
        int n = arr.length;
        int[] distr_l = new int[n];
        int[] distr_r = new int[n];
        distr_l[0]=1;distr_r[n-1]=1;
        for(int i=1;i<n;i++){ // 从左往右遍历
            if(arr[i] > arr[i-1]) distr_l[i]=distr_l[i-1]+1;
            else distr_l[i]=1;
        }
        for(int i=n-2;i>=0;i--){ // 从右往左遍历
            if(arr[i] > arr[i+1]) distr_r[i]=distr_r[i+1]+1;
            // 省去一个数组distr[i]=Math.max(distr[i],distr_l[i-1]+1);
            else distr_r[i]=1;
        }
        int sum = 0;
        for(int i=0;i<n;i++){ // 求最大值
            sum += Math.max(distr_l[i],distr_r[i]);
        }
        return sum;
    }


    /**
     * 给出权重比，每个人最少分一个，权重大于左边，则糖果数大于左边，权重大于右边，则糖果数大于右边，求最少分出的糖果总数
     */
    public static void main(String[] args) {
        分糖果三 main = new 分糖果三();
        System.out.println(main.distributeCandier(new int[] {1,1,2})); // 4 = [1,1,2]
        System.out.println(main.distributeCandier(new int[] {1,1,1})); // 3 = [1,1,1]
        System.out.println(main.distributeCandier(new int[] {1,4,2,7,9})); // 9 = [1,2,1,2,3]
    }
}
