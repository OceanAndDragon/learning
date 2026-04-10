public class code {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) {
            return;
        }
        int start = 0, curr = 0, assign = nums[curr];
        for (int i = 0; i < n; i++) {
            // calculate next index
            int next = (curr + k) % n;
            // store next assign value to temp
            int temp = nums[next];
            // shift element
            nums[next] = assign;
            // reassign temp value to next assign
            assign = temp;
            // check if there is a cycle
            if (next == start) {
                // increment start
                start++;
                // shift curr to updated start index to avoid cycle
                curr = start;
                // get next assign value from updated index
                assign = nums[curr];
            } else {
                curr = next;
            }
        }
    }
}
