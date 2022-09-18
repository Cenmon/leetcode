package Utils;

import java.util.Arrays;

public class ArrayUtils {


	public static void print(int[] arr,String... name){
        if(name.length > 0) System.out.print( name[0] + " ");
        System.out.print("arrays:");
        System.out.println(Arrays.toString(arr));
    }

    public static void print(double[] arr,String... name){
        if(name.length > 0) System.out.print( name[0] + " ");
        System.out.print("arrays:");
        System.out.println(Arrays.toString(arr));
    }

    public static void print(char[] arr,String... name){
        if(name.length > 0) System.out.print( name[0] + " ");
        System.out.print("chars:");
        System.out.println(Arrays.toString(arr));
    }

    public static void print(boolean[] arr,String... name){
        if(name.length > 0) System.out.print( name[0] + " ");
        System.out.print("booleans:");
        System.out.println(Arrays.toString(arr));
    }

    public static void print(String[] arr,String... name){
        if(name.length > 0) System.out.print( name[0] + " ");
        System.out.print("strings:");
        System.out.println(Arrays.toString(arr));
    }

    public static void print(int[][] arr,String... name){
        if(name.length > 0) System.out.print( name[0] + " ");
        System.out.print("array[][]:");
        System.out.println(Arrays.deepToString(arr));
        System.out.println();
    }
}