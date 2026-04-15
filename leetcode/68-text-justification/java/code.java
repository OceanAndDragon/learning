import java.util.ArrayList;
import java.util.List;

public class code {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int numWords = 0, currLength = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            boolean leftJustify = numWords == 1;
            // check if we can add current word
            int newLength = currLength + words[i].length() + numWords;
            // we cannot add current word
            // start space distribution
            if (maxWidth < newLength) {
                result.add(getJustifiedWords(words, i - numWords, i, maxWidth, currLength, numWords, leftJustify));
                // should reset the currLength and numWords
                currLength = 0;
                numWords = 0;
            }
            currLength += words[i].length();
            numWords++;
            // end of the words
            if (i == n - 1) {
                leftJustify = true;
                result.add(getJustifiedWords(words, i - numWords + 1, i + 1, maxWidth, currLength, numWords, leftJustify));
            }
        }
        return result;
    }

    public String getJustifiedWords(String[] words, int start, int end, int maxWidth, int currLength, int numWords, boolean leftJustify) {
        StringBuilder curr = new StringBuilder();
        // left justify
        if (leftJustify) {
            int spaces = maxWidth - currLength - (numWords - 1);
            for (int i = start; i < end; i++) {
                if (!curr.isEmpty()) {
                    curr.append(" ");
                }
                curr.append(words[i]);
            }
            for (int i = 0; i < spaces; i++) {
                curr.append(" ");
            }
            return curr.toString();
        }
        // calculate spaces
        int evenSpaces = (maxWidth - currLength) / (numWords - 1);
        int extraSpaces = (maxWidth - currLength) % (numWords - 1);
        // from start to end, we need to construct a string by distributing the space
        for (int j = start; j < end; j++) {
            // if this is not first word, put spaces
            if (!curr.isEmpty()) {
                // put even spaces
                for (int k = 0; k < evenSpaces; k++) {
                    curr.append(" ");
                }
                // put extra space if needed
                if (extraSpaces > 0) {
                    curr.append(" ");
                    extraSpaces--;
                }
            }
            // append current word
            curr.append(words[j]);
        }
        // put constructed string to result list
        return curr.toString();
    }
    
}
