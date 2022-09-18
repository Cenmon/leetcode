package 数据结构.链表.中间节点;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 * @Description 同链表倒数第k个节点，快慢指针之间需要相隔k个节点，即中间节点快慢指针最终相差n/2个节点
 */
public class 链表中间节点 {

    public ListNode search(ListNode head){
        ListNode slow=head,fast=head.next; // slow指向第一个节点，fast指向第二个节点
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
