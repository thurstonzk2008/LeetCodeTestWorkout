package com.zhk.List;

/**
 * @author zhuhk
 * @create 2020-05-29 7:31 上午
 * @Version 1.0
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        ListNode first = null;
        ListNode second = head;
        while (second != null ) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        return first;

    }
}
