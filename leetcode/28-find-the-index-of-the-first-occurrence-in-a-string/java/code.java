public class code {

    public int strStr1(String haystack, String needle) {
        int j, m = haystack.length(), n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            int k = i;
            j = 0;
            while (j < n) {
                if (haystack.charAt(k) != needle.charAt(j))
                    break;
                else {
                    k++;
                    j++;
                }
            }
            // found the needle from haystack
            if (j == n) {
                return k - n;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        // construct array of Longest Prefix Suffix
        int[] lps = constructLPS(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            // if current chars are equal, keep going
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            // if we are at the beginning of the needle
            // shift haystack
            else if (j == 0) {
                i++;
            }
            // keep shifting the window of needle
            else {
                j = lps[j - 1];
            }
            // we found needle from haystack
            // return start index
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }

    /**
     * KMP Algorithm to generate lps array
     * @param s
     * @return lps
     */
    public int[] constructLPS(String s) {
        // index to track of the longest prefix suffix
        int[] lps = new int[s.length()];
        int prevLPS = 0, i = 1;
        while (i < s.length()) {
            // found the longest prefix suffix
            // store found index + 1
            if (s.charAt(prevLPS) == s.charAt(i)) {
                lps[i++] = prevLPS + 1;
                prevLPS++;
            }
            // could not find it
            // set to 0 and move on
            else if (prevLPS == 0) {
                lps[i++] = 0;
            }
            // keep find the longest prefix suffix from lps
            else {
                prevLPS--;
            }
        }
        return lps;
    }

}