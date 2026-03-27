import ds.ListNode;
import java.util.Stack;

public class code {

    public int pairSum1(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead, fast = newHead;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        slow = slow.next;
        int currSum = 0, maxSum = 0;
        while (slow != null) {
            currSum = stack.pop() + slow.val;
            maxSum = Math.max(maxSum, currSum);
            slow = slow.next;
        }
        return maxSum;
    }

    public int pairSum2(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead, fast = newHead, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // reverse the first half nodes
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode first = slow, second = slow.next;
        // reverse the last node
        slow.next = prev;
        int currSum = 0, maxSum = 0;
        while (first != null && second != null) {
            currSum = first.val + second.val;
            maxSum = Math.max(maxSum, currSum);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }

}