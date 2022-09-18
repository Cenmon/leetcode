package 数据结构.二叉树;

import Utils.ArrayUtils;
import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 有序数组构建平衡二叉搜索树 {

    public TreeNode create(int[] arr){
        TreeNode head = doCreate(arr,0,arr.length-1);
        return head;
    }

    private TreeNode doCreate(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = doCreate(arr,start,mid-1);
        root.right = doCreate(arr,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        有序数组构建平衡二叉搜索树 main = new 有序数组构建平衡二叉搜索树();

        int[] arr = new int[]{1,3,4,6,9,13};
        new ArrayUtils().print(arr);
        TreeNode head = main.create(arr);
        new TreeUtils().levelPrint(head);
    }
}
