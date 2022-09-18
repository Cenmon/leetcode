package 双指针.快慢指针.移除元素;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 删除排序链表中的重复元素三 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode phead = new ListNode(head.val-1,head);

        ListNode slow=phead,fast = head,pre=phead;
        while(fast != null){
            // 前驱和后继值都不等于
            if(fast.val != pre.val && (fast.next == null || fast.val != fast.next.val)){
                slow.next = fast; // 上链
                slow = slow.next;
            }else{
                pre.next = null; // 垃圾回收
            }
            pre = fast;
            fast = fast.next;
        }
        return phead.next;
    }

    public static void main(String[] args) {
        删除排序链表中的重复元素三 main = new 删除排序链表中的重复元素三();

        ListUtils.print(main.deleteDuplicates(ListUtils.create(new int[]{1,2,3,3,4,4,5}))); //1,2,5
        ListUtils.print(main.deleteDuplicates(ListUtils.create(new int[]{1,1,1,2,3}))); // 2,3
    }
}
