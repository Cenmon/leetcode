package Interviewee;


import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(maxScore(arr,n));
        }
    }

    private static int maxScore(int[] arr, int n) {
        return 0;
    }
}
