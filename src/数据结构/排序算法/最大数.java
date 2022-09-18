package 数据结构.排序算法;

import Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-03-06 2022-03-06
 */
public class 最大数 {

    /**给定一个长度为n的数组nums，数组由一些非负整数组成，现需要将他们进行排列并拼接，
     * 每个数不可拆分，使得最后的结果最大，返回值需要是string类型，否则可能会溢出。
     * 输入：
     * [2,20,23,4,8]
     * 返回值：
     * "8423220"
     *
     * 冒泡排序的变种：冒泡排序两两比较，大值上浮；该问题中，两两拼接，拼接值小则上浮
     */
    public String solve (int[] nums) {
        // write code here
        if(nums == null) return new String();
        if(nums.length==1) return String.valueOf(nums[0]);

        String[] strings = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strings[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> Integer.valueOf(o2+o1)-Integer.valueOf(o1+o2));
        if(strings[0].equals("0")) return "0"; // nums全是0的情况
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        最大数 main = new 最大数();
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] arr = new int[] {2,20,23,4,8};
//        int[] arr = new int[] {0,0}; //0?????
        arrayUtils.print(arr);
        String res = main.solve(arr);
        System.out.println("res = " + res);
    }
}
