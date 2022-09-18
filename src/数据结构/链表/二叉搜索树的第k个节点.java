package 数据结构.链表;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-14 2022-03-14
 */
public class 二叉搜索树的第k个节点 {

    public int KthNode (TreeNode proot, int k) { // 非递归中序遍历
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = proot;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                k--;
                if(k == 0) return p.val;
                p = p.right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        二叉搜索树的第k个节点 main = new 二叉搜索树的第k个节点();
        TreeUtils treeUtils = new TreeUtils();
        TreeNode head = treeUtils.create(new int[]{5, 3, 7, 2, 4, 6, 8});
        treeUtils.levelPrint(head);
        int res = main.KthNode(head, 3); // 4(排序后第三个数)
        System.out.println("res = " + res);
    }
}
