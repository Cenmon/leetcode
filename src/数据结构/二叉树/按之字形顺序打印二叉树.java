package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-04 2022-03-04
 */
public class 按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        ArrayList<Integer> list = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            list = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                list.add(node.val);
                if(node.left != null) stack2.push(node.left);
                if(node.right != null) stack2.push(node.right);
            }
            if(list.size()>0) res.add(list);

            list = new ArrayList<>();
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                list.add(node.val);
                if(node.right != null) stack1.push(node.right);
                if(node.left != null) stack1.push(node.left);
            }
            if(list.size()>0) res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        按之字形顺序打印二叉树 main = new 按之字形顺序打印二叉树();

        TreeUtils treeUtils = new TreeUtils();
//        TreeNode root = treeUtils.create(new int[] {1,2,3,-1,-1,4,5});
        TreeNode root = treeUtils.create(new int[] {8,6,10,5,7,9,11});
        treeUtils.levelPrint(root);
        System.out.println("main.Print(root) = " + main.Print(root));
    }
}
