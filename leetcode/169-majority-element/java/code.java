public class code {

    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            // if count is equal to 0, need to set the result to current number
            // then increment the count
            if (count == 0) {
                candidate = num;
                count++;
            }
            // if count > 0 and candidate is not equal to current number,
            // decrement the count
            else if (candidate != num) {
                count--;
            }
            // if count > 0 and candidate is equal to current number,
            // increment the count
            else {
                count++;
            }
        }
        return candidate;
    }

}