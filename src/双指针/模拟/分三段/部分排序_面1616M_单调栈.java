package 双指针.模拟.分三段;

/**
 * @Author Cenmo
 * @Date 2022-08-23 2022-08-23
 * @Description 三段式分析 or 单调栈
 */
public class 部分排序_面1616M_单调栈 {

    // 三段式分析：数组分成numA,numB,numC,其中numA和numsC有序，同时保证numA中元素均小于numB，numsC元素均大于numB
    public int[] subSort2(int[] array) { // 三段式分析
        int n=array.length,left=0,right=n-1;
        while(left+1<n && array[left]<=array[left+1]) left++;
        if(n==0 || left == n-1) return new int[]{-1,-1};
        while(right-1>=0 && array[right]>=array[right-1]) right--;

        int end = right;
        for(int i=left+1;i<end;i++){
            while(left>=0 && array[i] < array[left]) left--;
            while(right<n && array[i] > array[right]) right++;
        }
        return new int[]{left+1,right-1};
    }

    public int[] subSort(int[] array) { // 单调栈
        int n=array.length,left=-1,right=-1;
        int top=0;
        for(int i=1;i<n;i++){
            if(array[i] >= array[top]){
                top = i;
            }else{
                right = i;
            }
        }
        top = n-1;
        for(int i=n-2;i>=0;i--){
            if(array[i] <= array[top]){
                top = i;
            }else{
                left = i;
            }
        }
        return new int[]{left,right};
    }


    public static void main(String[] args) {
        部分排序_面1616M_单调栈 main = new 部分排序_面1616M_单调栈();

        System.out.println(main);
    }
}
