import java.util.Arrays;

public class code {
    
    public int hIndex1(int[] citations) {
        // sort in descending order
        citations = Arrays.stream(citations).boxed().sorted((c1, c2) -> c2 - c1).mapToInt(Integer::intValue).toArray();
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            // if condition satisfies, update h
            if (citations[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        // buckets for bucket sort
        int[] buckets = new int[n + 1];
        for (int citation : citations) {
            buckets[Math.min(citation, n)]++;
        }
        // counting the citations
        int counts = 0;
        for (int i = n; i >= 0; i--) {
            counts += buckets[i];
            // if the counts is greater than current index,
            // we are at h-index
            if (counts >= i) {
                return i;
            }
        }
        return 0;
    }

}
