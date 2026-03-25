import ds.ListNode;

public class code {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead, curr = head, ptr = newHead;
        int n = 0;
        // get total count of the nodes
        while (ptr.next != null) {
            ptr = ptr.next;
            n++;
        }
        // number of groups in current nodes
        int g = n / k;
        for (int i = 0; i < g; i++) {
            int j = 1;
            // repeat by k nodes
            while (j < k) {
                ListNode currNext = curr.next;
                ListNode prevNext = prev.next;
                ListNode currNextNext = curr.next.next;
                prev.next = currNext;
                curr.next.next = prevNext;
                curr.next = currNextNext;
                j++;
            }
            prev = curr;
            curr = curr.next;
        }
        return newHead.next;
    }

}