package 动态规划.自上而下分解.进阶;

import Utils.TreeNode;

/**
 * @author Cenmo
 * @Date 2022-03-29 2022-03-29
 */
public class 打家劫舍三 {

    public int Treasurehunt (TreeNode root) {
        // write code here
        return process(root.left) + process(root);
    }

    private int process(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right !=null) return root.val;
        if(root.left == null && root.right != null) {
            return Math.max(root.val+process(root.right.left)+process(root.right.right),process(root.right));
        }
        if(root.right == null && root.left !=null) {
            return Math.max(root.val+process(root.left.left)+process(root.left.right),process(root.left));
        }
        return Math.max(root.val+process(root.left.left)+process(root.left.right)+process(root.right.left)+process(root.right.right),process(root.left)+process(root.right));
    }



    public static void main(String[] args) {
        打家劫舍三 main = new 打家劫舍三();
    }
}
