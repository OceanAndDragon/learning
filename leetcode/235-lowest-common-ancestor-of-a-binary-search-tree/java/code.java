import ds.TreeNode;

public class code {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        // if current value is less than min, LCAs are in right subtrees
        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // if current value is larger than max, LCAs are in left subtrees
        else if (max < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // we are at LCA
        return root;
    }
    
}
