package 数据结构.合并问题;

import Utils.ArrayUtils;

public class 合并两个有序的数组 {

	public void merge(int A[], int m, int B[], int n) {
        int i=m-1,j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(A[i] >= B[j]) A[k--] = A[i--];
            else A[k--]=B[j--];
        }
        while(i>=0) A[k--]=A[i--];
        while(j>=0) A[k--]=B[j--];
    }

	public static void main(String[] args){
		合并两个有序的数组 main = new 合并两个有序的数组();
		// ListUtils listUtil = new ListUtils();
		ArrayUtils arrayUtil = new ArrayUtils();

		int[] arrA = new int[] {4,5,6};
		int[] arrB = new int[] {1,2,3};

		main.merge(arrA,arrA.length,arrB,arrB.length);
		arrayUtil.print(arrA);
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}