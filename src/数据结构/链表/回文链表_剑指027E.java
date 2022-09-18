package 数据结构.链表;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 */
public class 回文链表_剑指027E {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        // 中间节点
        ListNode slow=head,fast=head.next,tmp;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表逆置
        fast = slow.next;
        slow.next = null;
        while(fast != null){
            tmp = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = tmp;
        }
        // 回文判断
        fast = slow.next;
        slow = head;
        while(fast != null && slow.val == fast.val){
            slow = slow.next;
            fast = fast.next;
        }
        return fast == null;
    }

    public static void main(String[] args) {
        回文链表_剑指027E main = new 回文链表_剑指027E();

        System.out.println(main.isPalindrome(ListUtils.create(new int[]{1,2,3,3,2,1}))); // true
        System.out.println(main.isPalindrome(ListUtils.create(new int[]{1,2}))); // false

    }
}
