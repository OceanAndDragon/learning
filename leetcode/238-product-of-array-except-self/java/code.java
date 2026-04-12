public class code {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, prefix = 1, suffix = 1;
        // output array : not considered as extra space
        int[] result = new int[n];
        // first get the prefixes
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        // then multiply each suffix
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
    
}
