package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-21 21:20
 * @Description
 */
public class 可移除字符的最大数目1898M {

    private int[] removePos;
    public int maximumRemovals(String s, String p, int[] removable) {
        removePos = new int[s.length()]; // removable[i] - i
        for(int i=0,n=removable.length;i<n;i++){
            removePos[ removable[i] ] = i+1;
        }

        // k的取值范围为0 <= k <= removable.length
        int left=0,right=removable.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            // s去除前mid个元素后，p还是s的子序列
            if(isSubsequenceAfterRemoval(s,p,removable,mid)){
                left = mid + 1; // 试探去除更大的k值
            }else{
                right = mid - 1; // 去除前k个后不是子序列，则去除前k+i个必定也不是
            }
        }
        return right;
    }

    private boolean isSubsequenceAfterRemoval(String s,String p,int[] removable,int k){
        int m=p.length(),n=s.length();
        for(int i=0,j=0;i<n;i++){
            if(removePos[i]>0 && removePos[i]<=k ) continue;
            if(s.charAt(i) == p.charAt(j)){
                if(++j == m) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        可移除字符的最大数目1898M main = new 可移除字符的最大数目1898M();

        /**
         * 给定字符串s和p,以及可从s中去除元素下标的数组removable, 其中p是s的子序列
         * 确定最大k，使得s去除removable记录的前k个下标后，p仍然是s的子序列
         */
        System.out.println(main.maximumRemovals("abcacb","ab",new int[]{3,1,0})); // 2
        System.out.println(main.maximumRemovals("abcbddddd","abcd",new int[]{3,2,1,4,5,6})); // 1
        System.out.println(main.maximumRemovals("abcab","abc",new int[]{0,1,2,3,4})); // 0
    }
}
