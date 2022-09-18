package Basic;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 链表中间节点 {

    public ListNode search(ListNode head){
        // slow=head,fast=head.next,即slow,fast起始位置为0节点，则返回偏左中间节点
        // slow=head,fast=head,即slow,fast起始位置为1节点，则返回偏右中间节点
        if(head == null) return head;
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        链表中间节点 main = new 链表中间节点();
        ListUtils listUtils = new ListUtils();

//        ListNode head = listUtils.create(new int[]{1,2,3,2,1}); // 3
        ListNode head = listUtils.create(new int[]{1,2,3,1}); // 下取整，应为2

        listUtils.print(head);
        ListNode res = main.search(head);
        System.out.println("res.val = " + res.val);

    }
}
