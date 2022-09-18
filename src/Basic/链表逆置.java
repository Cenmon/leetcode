package Basic;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @Author Cenmo
 * @Date 2022-08-23 2022-08-23
 * @Description
 */
public class 链表逆置 {

    public ListNode reverse(ListNode head){ // 不带头结点
        if(head == null) return head;
        ListNode p=head;
        head = null;
        while( p != null ){
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        return head;
    }

    public ListNode reverse2(ListNode head){ // 不带头结点
        if(head == null) return head;
        ListNode p=head.next;
        head.next = null;
        while( p != null ){
            ListNode tmp = p.next;
            p.next = head.next;
            head.next = p;
            p = tmp;
        }
        return head;
    }


    public static void main(String[] args) {
        链表逆置 main = new 链表逆置();

        ListUtils.print(main.reverse(ListUtils.create(new int[]{1,2,3,4,5}))); // 5,4,3,2,1
        ListUtils.print(main.reverse2(ListUtils.create(new int[]{1,2,3,4,5}))); // 1,5,4,3,2
    }
}
