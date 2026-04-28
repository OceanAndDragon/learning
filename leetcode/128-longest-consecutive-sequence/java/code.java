import java.util.HashSet;
import java.util.Set;

public class code {

    public int longestConsecutive(int[] nums) {
        int maxSequence = 0;
        Set<Integer> numSet = new HashSet<>();
        // add num into set
        for (int num : nums) {
            numSet.add(num);
        }
        // look at set
        for (int start : numSet) {
            if (!numSet.contains(start - 1)) {
                int curr = start, currSequence = 0;
                while (numSet.contains(curr)) {
                    curr++;
                    currSequence++;
                }
                maxSequence = Math.max(maxSequence, currSequence);
            }
        }
        return maxSequence;
    }
    
}
