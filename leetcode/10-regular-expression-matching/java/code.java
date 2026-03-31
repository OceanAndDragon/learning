public class code {

    public boolean isMatching1(String s, String p) {
        int m = s.length(), n = p.length();
        // store state:
        // -1: false, 0: not visited, 1: true
        int[][] dp = new int[m + 1][n + 1];
        return isMatching1(s, p, dp, 0, 0);
    }

    public boolean isMatching1(String s, String p, int[][] dp, int i, int j) {
        int m = s.length(), n = p.length();
        // reached to end of pattern
        // check if reached to end of string, too.
        if (j == n) {
            return i == m;
        }
        // check if we already visited
        else if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        // check if pattern is acceptable with current char
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        // check the wildcard first
        // 1. matches zero elements -> move pattern pointer to next to wildcard
        // 2. one of more matches -> move string pointer to see if we have more matches
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            match = isMatching1(s, p, dp, i, j + 2) || (match && isMatching1(s, p, dp, i + 1, j));
        } else if (match) {
            // current pattern matches with current char, proceed to next pointers
            match = isMatching1(s, p, dp, i + 1, j + 1);
        }
        // store current state
        dp[i][j] = match ? 1 : -1;
        return match;
    }

    public boolean isMatching2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case: both empty will be true
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // check if current pattern is valid
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                // check wildcard
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    // zero occurrence OR one or more occurrence
                    dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                } else if (match) {
                    // get the state of next
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
    
}
