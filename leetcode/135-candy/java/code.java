import java.util.Arrays;

public class code {

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] counts = new int[n];
        counts[0] = 1;
        // process from left to right to keep track of the ascending pattern
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                counts[i] = counts[i - 1] + 1;
            } else {
                counts[i] = 1;
            }
        }
        // process from right to left to keep track of the descending pattern
        for (int i = n - 2; i >=0 ; i--) {
            if (ratings[i + 1] < ratings[i]) {
                counts[i] = Math.max(counts[i], counts[i + 1] + 1);
            }
        }
        // return the sum of counts
        return Arrays.stream(counts).sum();
    }

    public int candy2(int[] ratings) {
        int i = 1, n = ratings.length, candies = ratings.length;
        while (i < n) {
            // if same ratings, we don't need to do anything
            if (ratings[i - 1] == ratings[i]) {
                i++;
            }
            // need to maintain the ascending slope and increment candies as asc at each process
            int asc = 0;
            while (i < n && ratings[i - 1] < ratings[i]) {
                asc++;
                candies += asc;
                i++;
                if (i == n) {
                    return candies;
                }
            }
            // likewise, need to maintain the descending slope and increment candies as desc at each process
            int desc = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                desc++;
                candies += desc;
                i++;
            }
            // we need to subtract the min(asc, desc) to avoid the double counting
            candies -= Math.min(asc, desc);
        }
        return candies;
    }

}