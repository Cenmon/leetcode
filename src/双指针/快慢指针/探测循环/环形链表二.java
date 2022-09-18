package 双指针.快慢指针.探测循环;

import Utils.ListNode;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 环形链表二 {

    /**
     * 环形链表长度为a+b,b为环长
     * 则慢指针走s,则快指针走f=2s=s+nb(两者相交于一点，快指针走到交点后再走n圈环)
     * 有s=nb，即慢指针走的路程为nb
     * 又有指针走k=a+nb,n=0,1,2...时到达交点
     * 故慢指针已走nb，再走a即可
     * 让快指针重回起点，满指针从交点开始，走相同步长，当快指针走到环入口时，走了a步，此时慢指针也走到了环入口
     * 故两者第二次相交的点即环入口
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null; // 无环
        ListNode slow=head,fast=head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null; // 无环
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        环形链表二 main = new 环形链表二();
    }
}
