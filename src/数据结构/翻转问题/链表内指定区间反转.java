package 数据结构.翻转问题;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-04 2022-03-04
 */
public class 链表内指定区间反转 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if(head==null || head.next==null) return head;
        ListNode headNode = new ListNode(-1);//链表处理多带头结点
        headNode.next = head;

        ListNode start=headNode,end=headNode;

        for(int i=0;i<m-1;i++) start = start.next;
        for(int i=0;i<n+1;i++) end = end.next;
//         System.out.println(start.val+" "+end.val);

        ListNode p=start.next,tmp;//p指向第一个需要翻转的节点
        start.next = end; //头指针指向尾结点的next
        while(p != end){
            tmp = p.next;
            p.next = start.next;
            start.next = p;
            p = tmp;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        链表内指定区间反转 main = new 链表内指定区间反转();

        ListUtils listUtils = new ListUtils();
        ListNode head = listUtils.create(new int[]{1, 2, 3, 4, 5});
        listUtils.print(head);
        ListNode res = main.reverseBetween(head, 2, 4);
        listUtils.print(res);
    }
}
