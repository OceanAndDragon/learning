import java.util.Stack;

public class code {

    public int longestValidParentheses1(String s) {
        int curr = 0, longest = 0;
        Stack<Integer> stack = new Stack<>();
        // Base case: if all parentheses are vaild
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // found the valid parenthesis combination
            if (s.charAt(i) == ')' && stack.peek() >= 0 && s.charAt(stack.peek()) == '(') {
                // pop open parenthesis from stack
                stack.pop();
                // get the current length
                curr = i - stack.peek();
                // store the longest
                longest = Math.max(longest, curr);
            } else {
                stack.push(i);
            }
        }
        return longest;
    }
    
}
