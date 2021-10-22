
/**
 * DCP : Problem #20 [Easy]
 * This problem was asked by Google.
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * In this example, assume nodes with the same value are the exact same node objects.
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */

public class IntersectingNodeLinkedList {
    public static void main(String[] args) {
        int[] listA = {1, 9, 1}; //{2, 6, 4};//{3, 7};
        int[] listB = {3}; //{1, 5};//{99, 1};
        int[] commonValues = {2, 4}; //{};//{8, 10};

        LinkedList llObj = new LinkedList();
        ListNode headA = llObj.createLinkedList(listA);
        ListNode headB = llObj.createLinkedList(listB);
        ListNode commonHead = llObj.createLinkedList(commonValues);
        llObj.mergeLinkedLists(headA, commonHead);
        llObj.mergeLinkedLists(headB, commonHead);

        ListNode intersectingNode = getIntersectingNode(headA, headB);
        if(intersectingNode != null)
            System.out.println("intersecting node = " + intersectingNode.val);
        else
            System.out.println("no intersecting node found !");
    }

    public static ListNode getIntersectingNode(ListNode headA, ListNode headB)
    {
        ListNode ptrA = headA, ptrB = headB;

        while(ptrA != ptrB)
        {
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }

        return  ptrA;
    }
}
