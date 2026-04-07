import ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class code {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCounts = new HashMap<>();
        return pathSum(root, prefixCounts, targetSum, 0L);
    }

    public int pathSum(TreeNode root, Map<Long, Integer> prefixCounts, int targetSum, long currSum) {
        if (root == null) {
            return 0;
        }
        // get current prefix sum
        long prefixSum = currSum + targetSum;
        int prefixCount = prefixCounts.getOrDefault(prefixSum, 0);
        // increment count
        prefixCounts.put(prefixSum, prefixCount + 1);
        // get current value
        long currVal = currSum + root.val;
        // get count from prefixCounts
        int count = prefixCounts.getOrDefault(currVal, 0);
        // add counts as we go down the tree
        count += (pathSum(root.left, prefixCounts, targetSum, currVal) + pathSum(root.right, prefixCounts, targetSum, currVal));
        // decrement count before we return the count
        prefixCounts.put(prefixSum, prefixCounts.get(prefixSum) - 1);
        return count;
    }

}