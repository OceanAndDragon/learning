import ds.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class code {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values, 0);
        return values;
    }

    public void dfs(TreeNode root, List<Integer> values, int i) {
        if (root == null) {
            return;
        } else if (i == values.size()) {
            values.add(root.val);
        } else if (values.get(i) < root.val) {
            values.set(i, root.val);
        }
        dfs(root.left, values, i + 1);
        dfs(root.right, values, i + 1);
    }

}