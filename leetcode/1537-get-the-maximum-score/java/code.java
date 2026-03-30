import java.util.HashMap;
import java.util.Map;

public class code {

    private final int MODULO = 100000007;

    public int maxSum1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        long[][] dp = new long[Math.max(m, n)][2];
        // indices lookup tables for each nums array
        Map<Integer, Integer> lookup1 = new HashMap<>(), lookup2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            lookup1.put(nums1[i], i);
        }
        for (int i = 0; i < n; i++) {
            lookup2.put(nums2[i], i);
        }
        return (int) Math.max(maxSum1(nums1, nums2, dp, lookup1, lookup2, 0, 0, 0), maxSum1(nums1, nums2, dp, lookup1, lookup2, 0, 0, 1));
    }

    public long maxSum1(int[] nums1, int[] nums2, long[][] dp, Map<Integer, Integer> lookup1, Map<Integer, Integer> lookup2, int i, int j, int row) {
        int m = nums1.length, n = nums2.length;
        if ((row == 0 && i == m) || (row == 1 && j == n)) {
            return 0;
        }
        int di = row == 0 ? i : j;
        long maxSum;
        if (dp[di][row] > 0) {
            return dp[di][row];
        }
        if (row == 0) {
            maxSum = maxSum1(nums1, nums2, dp, lookup1, lookup2, i + 1, j, row) + nums1[i] % MODULO;
            // if found value in other array, we switch to other array
            if (lookup2.containsKey(nums1[i])) {
                maxSum = Math.max(maxSum, maxSum1(nums1, nums2, dp, lookup1, lookup2, i, lookup2.get(nums1[i]) + 1, 1) + nums1[i]) % MODULO;
            }
        } else {
            maxSum = maxSum1(nums1, nums2, dp, lookup1, lookup2, i, j + 1, row) + nums2[j] % MODULO;
            // if found value in other array, we switch to other array
            if (lookup1.containsKey(nums2[j])) {
                maxSum = Math.max(maxSum, maxSum1(nums1, nums2, dp, lookup1, lookup2, lookup1.get(nums2[j]) + 1, j, 0) + nums2[j]) % MODULO;
            }
        }
        dp[di][row] = maxSum;
        return dp[di][row];
    }

    public int maxSum2(int[] nums1, int[] nums2) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        long dp1 = 0L, dp2 = 0L;
        while (i < m || j < n) {
            if (j == n || (i < m && nums1[i] < nums2[j])) {
                dp1 += nums1[i++];
            } else if (i == m || (j < n && nums2[j] < nums1[i])) {
                dp2 += nums2[j++];
            } else {
                // if both values are equal, update both scores to max of two scores
                dp1 = dp2 = Math.max(dp1, dp2) + nums1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(dp1, dp2) % MODULO);
    }

}