package 双指针.快慢指针;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class 旋转链表 {

    // 即求倒数第k个节点，其作为新表头
    public ListNode rotateRight(ListNode head, int k) {
        ListNode slow=head,fast=head;
        if(head == null) return head;
        int n=0;
        for(ListNode p = head;p!=null;p=p.next) n++;
        for(int i=0;i<k%n;i++) fast = fast.next; //倒数第k个的前驱，即倒数第k+1个作为表尾

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        旋转链表 main = new 旋转链表();

        ListNode head = ListUtils.create(new int[]{1,2,3,4,5});
        ListUtils.print(head);
        ListUtils.print(main.rotateRight(head,2)); // 4,5,1,2,3

        ListNode head2 = ListUtils.create(new int[]{0,1,2});
        ListUtils.print(head2);
        ListUtils.print(main.rotateRight(head2,4)); //2,0,1

    }
}
