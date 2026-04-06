import ds.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class code {
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), root, targetSum, 0);
        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> curr, TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return;
        }
        curr.add(root.val);
        currSum += root.val;
        // if leaf node and curr sum is equal to target,
        // add to result list
        if (root.left == null && root.right == null && targetSum == currSum) {
            results.add(new ArrayList<>(curr));
        } else {
            dfs(results, curr, root.left, targetSum, currSum);
            dfs(results, curr, root.right, targetSum, currSum);
        }
        // remove the current node value from current list
        curr.remove(curr.size() - 1);
    }

}