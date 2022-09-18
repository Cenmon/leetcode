package 数据结构.二叉树;

import Utils.ArrayUtils;
import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cenmo
 * @Date 2022-03-15 2022-03-15
 */
public class 判断一棵二叉树是否为搜索二叉树和完全二叉树 {

    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0] = IsBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        res[1] = IsCBT(root);
        return res;
    }

    private boolean IsCBT(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                while (!queue.isEmpty()){
                    if(queue.poll() != null) return false;
                }
            }
        }
        return true;
    }

    public boolean IsBST(TreeNode root,int min,int max){
        if( root == null ) return true;
        if(root.val < min || root.val > max) return false;
        return IsBST(root.left,min,root.val) && IsBST(root.right,root.val,max);
    }

    public static void main(String[] args) {
        判断一棵二叉树是否为搜索二叉树和完全二叉树 main = new 判断一棵二叉树是否为搜索二叉树和完全二叉树();

        TreeUtils treeUtils = new TreeUtils();
//        TreeNode head = treeUtils.create(new int[]{2, 1, 3});
//        TreeNode head = treeUtils.create(new int[]{1,-1,2});
        TreeNode head = treeUtils.create(new int[]{3,2,5,1,4});
        boolean[] booleans = main.judgeIt(head);
        new ArrayUtils().print(booleans);
    }
}
