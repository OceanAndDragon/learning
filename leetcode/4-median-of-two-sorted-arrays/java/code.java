public class code {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // median index if nums1 and nums2 are merged
        int k = (m + n) / 2;
        // if sum of length is even, need to find two median and divide by 2
        if ((m + n) % 2 == 0) {
            return ((double) (findMedian(nums1, nums2, k - 1, 0, m - 1, 0, n - 1) + findMedian(nums1, nums2, k, 0, m - 1, 0, n - 1)) / 2);
        }
        // if sum of length is odd, just need to return one median value
        else {
            return findMedian(nums1, nums2, k, 0, m - 1, 0, n - 1);
        }
    }

    public int findMedian(int[] nums1, int[] nums2, int k, int s1, int e1, int s2, int e2) {
        // if not in nums1, then it should be in nums2
        // should subtract s1 from k
        if (e1 < s1) {
            return nums2[k - s1];
        }
        // if not in nums2, then it should be in nums1
        // should subtract s2 from k
        else if (e2 < s2) {
            return nums1[k - s2];
        }
        // get the mid indices of both arrays and their values
        int m1 = s1 + (e1 - s1) / 2, m2 = s2 + (e2 - s2) / 2;
        int v1 = nums1[m1], v2 = nums2[m2];
        // if the sum is less than k, that means we are not reached at the median
        if (m1 + m2 < k) {
            // if v2 is greater, then need to increase the v1
            if (v1 < v2) {
                return findMedian(nums1, nums2, k, m1 + 1, e1, s2, e2);
            }
            // if v1 is greater, then need to increase the v2
            else {
                return findMedian(nums1, nums2, k, s1, e1, m2 + 1, e2);
            }
        }
        // if the sum is greater than k, that means we passed the median
        else {
            // if v2 is greater, then need to decrease the v2
            if (v1 < v2) {
                return findMedian(nums1, nums2, k, s1, e1, s2, m2 - 1);
            }
            // if v1 is greater, then need to decrease the v1
            else {
                return findMedian(nums1, nums2, k, s1, m1 - 1, s2, e2);
            }
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // if nums1 has larger length, swap two arrays.
        if (m > n) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int l = 0, r = m;
        while (l <= r) {
            // get the mid point
            int mid1 = l + (r - l) / 2;
            // with mid point of nums1, get the mid point of nums2
            int mid2 = (m + n + 1) / 2 - mid1;
            // get the left side of value
            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            // get the right side of value
            int minRight1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int minRight2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];
            // if both left sides are less than right sides, we found the median point
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return ((double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2);
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            // if left is larger, we need to decrease the range
            else if (maxLeft1 > minRight2) {
                r = mid1 - 1;
            }
            // if left is smaller, we need to increase the range
            else {
                l = mid1 + 1;
            }
        }
        return 0.0;
    }
    
}
