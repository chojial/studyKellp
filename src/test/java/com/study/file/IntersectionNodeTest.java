package com.study.file;

public class IntersectionNodeTest {



    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setVal(1);
        listNode.setVal(2);
        ListNode listNode2 = new ListNode(2);
        listNode2.setVal(2);
        listNode2.setVal(3);
        ListNode intersectionNode = getIntersectionNode(listNode, listNode2);
        System.out.println(intersectionNode);
    }
}
