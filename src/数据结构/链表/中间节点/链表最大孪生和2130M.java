package 数据结构.链表.中间节点;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-08-20 2022-08-20
 */
public class 链表最大孪生和2130M {

    public int pairSum(ListNode head) {
        ListNode slow=head,fast=head.next,tmp=null;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 逆置
        fast = slow.next;
        slow.next = null;
        while(fast != null){
            tmp = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = tmp;
        }
        // 求和
        fast = slow.next;
        slow = head;
        int max = 0;
        while(fast != null){
            if(slow.val + fast.val > max){
                max = slow.val + fast.val;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return max;
    }


    public static void main(String[] args) {
        链表最大孪生和2130M main = new 链表最大孪生和2130M();

        /**
         * 给定偶数节点个数的链表，孪生和指第k个节点和倒数第k个节点的和，返回链表的最大孪生和
         */
        System.out.println(main.pairSum(ListUtils.create(new int[]{5,4,2,1}))); // 6
        System.out.println(main.pairSum(ListUtils.create(new int[]{4,2,2,3}))); // 7
        System.out.println(main.pairSum(ListUtils.create(new int[]{1,100000}))); // 100001
    }
}
