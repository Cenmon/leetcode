package 双指针.对撞指针.两数之和;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-31 2022-07-31
 */
public class 三数之和的多种可能923 {

    public int threeSumMulti2(int[] arr, int target) { // 中心扩散
        int n = arr.length,left = 0, right = 0;
        long ans = 0,mod = 1000000007;
        Arrays.sort(arr);
        for(int pivot=1;pivot<n-1;pivot++){
            left=0;right=n-1;
            while(left < pivot && pivot < right){
                int sum = arr[left] + arr[right] + arr[pivot];
                if(sum == target){
                    int count1=1,count2=1;
                    while(++left<pivot && arr[left]==arr[left-1]){
                        count1++;
                    }
                    while(--right>pivot && arr[right]==arr[right+1]){
                        count2++;
                    }
                    ans += count1 * count2;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return (int)(ans % mod);
    }

    private long ans = 0;
    public int threeSumMulti(int[] arr, int target) { // 左扩散
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i] * 3.0 > target){
                break;
            }else if(arr[i] + arr[n-1]*2.0 < target){
                continue;
            }else{
                twoSum(arr,i+1,n-1,(long)target-arr[i]);
            }
        }
        return (int)ans;
    }

    private void twoSum(int[] arr,int left,int right,long target){
        while(left < right){
            if(arr[left] + arr[right] < target){
                left++;
            }else if(arr[left] + arr[right] > target){
                right--;
            }else{
                if(arr[left] == arr[right]){
                    ans = (ans + (long)(right-left+1)*(right-left)/2) % 1000000007;
                    break;
                }
                int count1=1,count2=1;
                while(++left<arr.length && arr[left]==arr[left-1]){
                    count1++;
                }
                while(--right>=0 && arr[right]==arr[right+1]){
                    count2++;
                }
                ans = (ans + (long)count1 * count2) % 1000000007;
            }
        }
    }

    public static void main(String[] args) {
        三数之和的多种可能923 main = new 三数之和的多种可能923();

        /**
         * 满足三数之和等于target的所有情况总数
         */
        System.out.println(main.threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5},8)); // 20
//        (1, 2, 5) 出现 8 次；
//        (1, 3, 4) 出现 8 次；
//        (2, 2, 4) 出现 2 次；
//        (2, 3, 3) 出现 2 次。
        System.out.println(main.threeSumMulti(new int[]{1,1,2,2,2,2},5)); // 12
    }
}
