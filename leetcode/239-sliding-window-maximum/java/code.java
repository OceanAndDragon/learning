import java.util.ArrayDeque;
import java.util.Deque;

public class code {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int j = 0, n = nums.length;
        int[] result = new int[n - k + 1];
        // double linked queue
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // we don't need index that is outside of the k window.
            // remove from queue
            while (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            // we only care about the max in the k window.
            // remove if it is less than the current value.
            while (!queue.isEmpty() && num >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[j++] = nums[queue.peek()];
            }
        }
        return result;
    }

}