import ds.ListNode;
import ds.TreeNode;

public class code {

    private ListNode gHead;

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

    public TreeNode sortedListToBST2(ListNode head) {
        this.gHead = head;
        int size = this.getSize(head);
        return this.sortedListToBST2(0, size - 1);
    }

    public TreeNode sortedListToBST2(int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST2(start, mid - 1);
        TreeNode root = new TreeNode(this.gHead.val);
        this.gHead = this.gHead.next;
        TreeNode right = sortedListToBST2(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
    
}
