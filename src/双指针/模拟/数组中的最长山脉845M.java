package 双指针.模拟;

public class 数组中的最长山脉845M {

    public int longestMountain2(int[] arr) { // 暴力解法:中心扩散
        int n = arr.length,left = 0,right = 0;
        int ans = 0;
        for(int i=1;i<n-1;i++){
            left = i;
            while(left-1 >= 0 && arr[left] > arr[left-1]){
                left--;
            }

            right = i;
            while(right+1 < n && arr[right] > arr[right+1]){
                right++;
            }

            if(left!=i && right!=i){
                ans = Math.max(ans,right-left+1);
            }
        }
        return ans;
    }

    // @Cenmo:单调性问题
    public int longestMountain(int[] arr) {
        int maxLength=0,n=arr.length;
        int increase = 0,decrease = 0, i = 1;
        while(i < n){
            increase = decrease = 0;

            /**
             * 计算单增单减元素个数：i设为1，判断i-1与i的单调性，单调则加一，最终结果再加一
             */
            while(i<n && arr[i-1] < arr[i]) {
                i++;increase++;
            }
            while(i<n && arr[i-1] > arr[i]) {
                i++;decrease++;
            }
            while(i<n && arr[i-1]==arr[i]) i++;

            if(increase > 0 && decrease > 0)
                // 无论递增还是递减，计算单调个数时，第一个元素都没有计算单调性
                maxLength = Math.max(maxLength,increase+decrease+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        数组中的最长山脉845M main = new 数组中的最长山脉845M();

        System.out.println(main.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(main.longestMountain(new int[]{2,2,2}));
    }
}
