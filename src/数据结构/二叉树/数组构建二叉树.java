package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 数组构建二叉树 {

    public TreeNode create(int[] arr){
        return doCreate(arr,1,arr.length);
    }

    private TreeNode doCreate(int[] arr,int index,int length){
//        System.out.println("index = " + index);
        if(index > length || arr[index-1] == -1) return null; //-1则为null

        TreeNode head = new TreeNode(arr[index-1]); //按节点编号构建，arr[0]对应第一个节点，便于后续对左右子树索引的确定
        head.left = doCreate(arr,2*index,length);
        head.right = doCreate(arr,2*index+1,length);
        return head;
    }

    public static void main(String[] args) {
        数组构建二叉树 main = new 数组构建二叉树();

        int[] arr = new int[]{1,2,3,4,5};
        TreeNode head = main.create(arr);
        new TreeUtils().levelPrint(head);
    }
}
