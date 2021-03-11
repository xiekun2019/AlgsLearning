package com.xiekun.algs;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class ReverseLinkedList {
    public ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1) {
            return reverseHeadToN(head, right);
        }

        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    public ListNode reverseHeadToN(ListNode head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseHeadToN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {

    }
}
