
public class LinkedList{
    public ListNode createLinkedList(int[] list)
    {
        if(list.length == 0)
            return null;

        ListNode head = new ListNode(list[0]);
        ListNode node = head;

        for(int i = 1; i < list.length; i++)
        {
            node.next = new ListNode(list[i]);
            node = node.next;
        }
        return head;
    }

    public void mergeLinkedLists(ListNode listA, ListNode listB)
    {
        while(listA.next != null)
            listA = listA.next;

        listA.next = listB;
    }

    public void printLinkedList(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode head)
    {
        this.val = val;
        this.next = head;
    }

}

