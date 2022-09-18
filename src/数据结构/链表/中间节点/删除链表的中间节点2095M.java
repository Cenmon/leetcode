package 数据结构.链表.中间节点;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-08-20 2022-08-20
 */
public class 删除链表的中间节点2095M {

    // @Cenmo:链表中间节点
    public ListNode deleteMiddle(ListNode head) {
        ListNode phead = new ListNode(0,head);
        // 若快慢指针均指向0节点，则最终结果为左侧中间节点，若均指向1节点，则最终结果为右侧中间节点

        ListNode slow=phead,fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.out.println(slow.val);
        slow.next = slow.next.next;
        return phead.next;
    }


    public static void main(String[] args) {
        删除链表的中间节点2095M main = new 删除链表的中间节点2095M();

        /**
         * 给定链表，删除偏右侧中间节点
         */

        ListUtils.print(main.deleteMiddle(ListUtils.create(new int[]{1,3,4,7,1,2,6}))); // [1,3,4,1,2,6]
        ListUtils.print(main.deleteMiddle(ListUtils.create(new int[]{1,2,3,4}))); // [1,2,4]
        ListUtils.print(main.deleteMiddle(ListUtils.create(new int[]{2,1})));// [2]
        ListUtils.print(main.deleteMiddle(ListUtils.create(new int[]{1})));// []
    }
}
