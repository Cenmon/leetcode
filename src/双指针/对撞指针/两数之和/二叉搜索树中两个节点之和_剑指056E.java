package 双指针.对撞指针.两数之和;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Cenmo
 * @Date 2022-08-27 20:01
 * @Description
 */
public class 二叉搜索树中两个节点之和_剑指056E {

    class SearchIterator{
        private Stack<TreeNode> lSearch = new Stack<>();
        private Stack<TreeNode> rSearch = new Stack<>();

        SearchIterator(TreeNode root){
            TreeNode p=root;
            while(p != null){
                lSearch.push(p);
                p = p.left;
            }
            p = root;
            while(p != null){
                rSearch.push(p);
                p = p.right;
            }
        }

        public int getLeftNext(){
            TreeNode next = lSearch.pop();
            TreeNode p = next.right;
            while(p != null){
                lSearch.push(p);
                p = p.left;
            }
            return next.val;
        }

        public int getRightNext(){
            TreeNode next = rSearch.pop();
            TreeNode p = next.left;
            while(p != null){
                rSearch.push(p);
                p = p.right;
            }
            return next.val;
        }
    }

    /**
     * 思想：二叉搜索树中最左边的节点值最小，最右边的节点值最大，只要能够左右获取下一个节点即可
     */
    public boolean findTarget2(TreeNode root, int k) {
        SearchIterator iterator = new SearchIterator(root);
        int left = iterator.getLeftNext();
        int right = iterator.getRightNext();
        while(left < right){
            if(left + right < k){
                left = iterator.getLeftNext();
            }else if(left + right > k){
                right = iterator.getRightNext();
            }else{
                return true;
            }
        }
        return false;
    }

    private List<Integer> data = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        MidOrder(root);
        int l=0,r=data.size()-1;
        int left=data.get(l),right=data.get(r);
        while(left < right){
            if(left + right < k){
                left = data.get(++l);
            }else if(left + right > k){
                right = data.get(--r);
            }else{
                return true;
            }
        }
        return false;
    }

    private void MidOrder(TreeNode root){
        if(root != null){
            MidOrder(root.left);
            data.add(root.val);
            MidOrder(root.right);
        }
    }

    public static void main(String[] args) {
        二叉搜索树中两个节点之和_剑指056E main = new 二叉搜索树中两个节点之和_剑指056E();

        /**
         * 给定二叉搜索树和定值k，返回二叉搜索树中是否存在两数和为k
         */
        System.out.println(main.findTarget(TreeUtils.create(new int[]{8,6,10,5,7,9,11}),12));//true
        System.out.println(main.findTarget(TreeUtils.create(new int[]{8,6,10,5,7,9,11}),22));//false
    }
}
