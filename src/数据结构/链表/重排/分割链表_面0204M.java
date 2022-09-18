package 数据结构.链表.重排;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @Author Cenmo
 * @Date 2022-08-23 2022-08-23
 * @Description
 */
public class 分割链表_面0204M {

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-101);
        ListNode moreHead = new ListNode(101);
        ListNode less = lessHead,more = moreHead;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                less.next = p;
                less = less.next;
            }else{
                more.next = p;
                more = more.next;
            }
            p = p.next;
        }
        less.next = moreHead.next;
        more.next = null;
        return lessHead.next;
    }

    public static void main(String[] args) {
        分割链表_面0204M main = new 分割链表_面0204M();

        /**
         * 给定链表和特定值x，将链表中小于x的值放在大于等于x之前(注：大于x的没规定放在x右边)
         */

        ListUtils.print(main.partition(ListUtils.create(new int[]{1,4,3,2,5,2}),3)); // [1,2,2,4,3,5]
        ListUtils.print(main.partition(ListUtils.create(new int[]{}),0)); // []
        ListUtils.print(main.partition(ListUtils.create(new int[]{2,1}),2)); // [1,2]
    }
}
