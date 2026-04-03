import ds.ListNode;
import ds.TreeNode;

public class code {

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        // at a leaf node
        else if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // found the mid
        TreeNode root = new TreeNode(slow.val);
        // disconnect the link
        prev.next = null;
        // generate left subtrees
        root.left = sortedListToBST(head);
        // generate right subtrees
        root.right = sortedListToBST(slow.next);
        return root;
    }
    
}
