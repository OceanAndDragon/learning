import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class code {

    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for (int num : nums) {
            if (!duplicate.add(num)) {
                return num;
            }
        }
        return 0;
    }

    public int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findDuplicate4(int[] nums) {
        int[] counts = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
            if (counts[nums[i]] > 1) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findDuplicate5(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]);
            if (nums[j] < 0) {
                return j;
            }
            nums[j] *= -1;
        }
        return 0;
    }

    public int findDuplicate6(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int n = nums[i];
            // this value is in right place, so skip it
            if (n == i + 1) {
                i++;
            }
            // duplicate value found
            else if (n == nums[n - 1]) {
                return n;
            }
            // swap the values, so the current value can be in the correct place
            else {
                nums[i] = nums[n - 1];
                nums[n - 1] = n;
            }
        }
        return 0;
    }

    public int findDuplicate7(int[] nums) {
        int slow = 0, fast = 0;
        // detect duplicate
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        // find duplicate
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
}
