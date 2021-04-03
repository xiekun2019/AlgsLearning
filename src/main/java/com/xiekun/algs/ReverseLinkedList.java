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
    // 反转链表 --- 递归
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

    // 反转链表 --- 迭代
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode pre = fakeNode;

        // 将 pre 移动到 left 位置的前一个位置
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        // 记录 left 位置的前一个位置
        ListNode leftPreNode = pre;
        // 记录 left 位置
        ListNode leftNode = pre.next;

        // 将 pre 移动到 right 位置
        for(int i = left; i <= right; i++){
            pre = pre.next;
        }

        // 记录 right 位置的后一个位置
        ListNode rightNextNode = pre.next;

        // 切断链表
        leftPreNode.next = null;
        pre.next = null;

        leftPreNode.next = reverse(leftNode);
        leftNode.next = rightNextNode;

        return fakeNode.next;
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode k = head;
        ListNode next = head;
        while(k != null){
            next = k.next;
            k.next = pre;
            pre = k;
            k = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
