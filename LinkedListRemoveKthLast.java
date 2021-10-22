
/**
 * DCP : Problem #26 [Medium]
 * This problem was asked by Google.
 * Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
 * The list is very long, so making more than one pass is prohibitively expensive.
 * Do this in constant space and in one pass.
 */

//Time Complexity : O(n)
// Space Complexity : O(1)

public class LinkedListRemoveKthLast {
    public static void main(String[] args) {
        int[] list = {1, 2, 3};//{1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList llObj = new LinkedList();
        ListNode head = llObj.createLinkedList(list);
        int k = 1;//2;//3;

        head = removeKthLast(head, k);
        llObj.printLinkedList(head);
    }

    public static ListNode removeKthLast(ListNode head, int k)
    {
        // given that k is lesser than length of Linked List
        if(k <= 0)
            return head;

        ListNode dummyHead = new ListNode(0, head);
        ListNode ptr1 = dummyHead, ptr2 = dummyHead;

        // ptr1 moves k steps forward to point kth node from start
        while(k-- > 0)
            ptr1 = ptr1.next;

        // now, ptr1 & ptr2 move in tandem
        // this way ptr1 travels remaining n-k nodes and ptr2 travels n-k from start
        // when ptr1 reaches to the end node; ptr2 reaches (n-k)th node from start, which is (k+1)th node from end
        while(ptr1.next != null)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // delete its successor : k-th node from end
        ptr2.next = ptr2.next.next;
        return dummyHead.next;
    }
}
