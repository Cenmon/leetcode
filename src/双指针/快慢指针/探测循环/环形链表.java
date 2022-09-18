package 双指针.快慢指针.探测循环;

import Utils.ListNode;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 环形链表 {


    public boolean hasCycle(ListNode head) { // 判断是否有环
        if(head == null) return false;
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        环形链表 main = new 环形链表();
    }
}
