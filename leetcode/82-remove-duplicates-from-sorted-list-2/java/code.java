import ds.ListNode;

public class code {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead, curr = head;
        boolean isDuplicate = false;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // set flag as true
                if (!isDuplicate) {
                    isDuplicate = true;
                }
                // skip the same value
                curr.next = curr.next.next;
            } else {
                // set flag as false
                if (isDuplicate) {
                    isDuplicate = false;
                    // need to skip current node since it is the last duplicate node
                    curr = curr.next;
                    prev.next = curr;
                } else {
                    // move node to next;
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        if (isDuplicate) {
            // if the last group of nodes is duplicate, skip it
            curr = curr.next;
            prev.next = curr;
        }
        return newHead.next;
    }

}