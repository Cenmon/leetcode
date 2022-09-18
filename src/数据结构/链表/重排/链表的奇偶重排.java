package 数据结构.链表.重排;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-04 2022-03-04
 */
public class 链表的奇偶重排 {

    public ListNode oddEvenList (ListNode head) {
        // write code here
//         NC133 链表的奇偶重排
        if(head==null || head.next==null) return head;
        ListNode odd=head,even=head.next;
        ListNode evenHead=even;

        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        链表的奇偶重排 main = new 链表的奇偶重排();

        ListUtils listUtils = new ListUtils();
        ListNode head = listUtils.create(new int[]{1, 2, 3, 4, 5, 6});//{1,3,5,2,4,6}
        listUtils.print(head);
        ListNode res = main.oddEvenList(head);
        listUtils.print(res);
    }
}
