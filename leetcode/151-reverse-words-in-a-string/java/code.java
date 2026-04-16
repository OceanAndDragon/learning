public class code {

    public String reverseWords1(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }

    public String reverseWords2(String s) {
        char[] singleChars = s.trim().toCharArray();
        int n = singleChars.length;
        // reverse entire string s
        reverse(singleChars, 0, n - 1);
        int end;
        for (int i = 0; i < n; i++) {
            if (singleChars[i] != ' ') {
                end = i;
                while (end < n && singleChars[end] != ' ') {
                    end++;
                }
                // reverse each word
                reverse(singleChars, i, end - 1);
                i = end;
            }
        }
        int read = 0, write = 0;
        // compact to handle multiple spaces between each word
        while (read < n) {
            if (singleChars[read] != ' ') {
                singleChars[write++] = singleChars[read++];
            } else {
                singleChars[write++] = ' ';
                while (read < n && singleChars[read] == ' ') {
                    read++;
                }
            }
        }
        return new String(singleChars, 0, write);
    }

    public void reverse(char[] singleChars, int start, int end) {
        while (start < end) {
            char temp = singleChars[start];
            singleChars[start] = singleChars[end];
            singleChars[end] = temp;
            start++;
            end--;
        }
    }

}