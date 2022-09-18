package Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cenmo
 * @Date 2022-03-04 2022-03-04
 */
public class TreeUtils {

    /**
     * 根据数组元素创建二叉树，空节点用-1表示
     * @param arr
     * @return
     */
    public static TreeNode create(int[] arr){
        return doCreate(arr,1,arr.length);
    }

    private static TreeNode doCreate(int[] arr,int index,int length){
//        System.out.println("index = " + index);
        if(index > length || arr[index-1] == -1) return null; //-1则为null

        TreeNode head = new TreeNode(arr[index-1]);
        head.left = doCreate(arr,2*index,length);
        head.right = doCreate(arr,2*index+1,length);
        return head;
    }

    /**
     * 层序遍历打印二叉树，不包括null节点
     * @param root
     */
    public static void levelPrint(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        System.out.print("tree:");
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();

                sb.append(node.val+",");

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        System.out.println( sb.substring(0,sb.length()-1) );
    }


}
