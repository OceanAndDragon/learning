import java.util.HashMap;
import java.util.Map;

public class code {
    
    public boolean isScramble(String s1, String s2) {
        return isScramble(new HashMap<>(), s1, s2);
    }

    public boolean isScramble(Map<String, Boolean> dp, String s1, String s2) {
        // BASE CASE: if s1 and s2 are equal, return true
        if (s1.equals(s2)) {
            return true;
        }
        // BASE CASE: if length of s1 and s2 are different, return false
        else if (s1.length() != s2.length()) {
            return false;
        }
        // construct key to store it in dp
        String key = String.format("%s#%s", s1, s2);
        // if key is in dp, get it
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int n = s1.length();
        // check if s1 and s2 have same number of letters before we actually check if they can be scrambled
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                dp.put(key, false);
                return false;
            }
        }
        // check if s1 and s2 can be scrambled
        boolean canScrambled = false;
        for (int i = 1; i < n; i++) {
            // without swap
            canScrambled = isScramble(dp, s1.substring(0, i), s2.substring(0, i)) && isScramble(dp, s1.substring(i), s2.substring(i));
            if (canScrambled) {
                break;
            }
            // with swap
            canScrambled = isScramble(dp, s1.substring(0, i), s2.substring(n - i)) && isScramble(dp, s1.substring(i), s2.substring(0, n - i));
            if (canScrambled) {
                break;
            }
        }
        // store the result
        dp.put(key, canScrambled);
        return canScrambled;
    }
}