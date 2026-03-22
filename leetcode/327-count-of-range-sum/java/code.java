public class code {
  
    public int countRangeSum1(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[i];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pfs = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pfs[i + 1] = pfs[i] + nums[i];
        }
        return countRangeSum2(pfs, 0, n, lower, upper);
    }

    public int countRangeSum2(long[] pfs, int start, int end, int lower, int upper) {
        // if divided and only have one element, return 0
        if (end <= start) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        // divide current pfs array into halves and sum the counts
        int count = countRangeSum2(pfs, start, mid, lower, upper) + countRangeSum2(pfs, mid + 1, end, lower, upper);
        // right side of pfs pointers
        int left = mid + 1, right = mid + 1;
        // left side of pfs pointer
        for (int i = start; i <= mid; i++) {
            while (left <= end && pfs[left] - pfs[i] < lower) {
                left++;
            }
            while (right <= end && pfs[right] - pfs[i] <= upper) {
                right++;
            }
            // increase the count
            count += (right - left);
        }
        // merge arrays with sorting
        merge(pfs, start, mid, end);
        return count;
    }

    public void merge(long[] pfs, int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid || j <= end) {
            long v1 = i > mid ? Long.MAX_VALUE : pfs[i];
            long v2 = j > end ? Long.MAX_VALUE : pfs[j];
            if (v1 < v2) {
                temp[k++] = v1;
                i++;
            } else {
                temp[k++] = v2;
                j++;
            }
        }
        System.arraycopy(temp, 0, pfs, start, temp.length);
    }

}
