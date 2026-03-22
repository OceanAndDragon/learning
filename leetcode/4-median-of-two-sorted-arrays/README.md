# 4. Median of Two Sorted Arrays

#### Link: https://leetcode.com/problems/median-of-two-sorted-arrays/

## Approach
### 1. **Binary Search**
#### General idea: Since both arrays are already sorted, we can treat them as one combined sorted array. Let k be the median position, which is (m + n) / 2, where m is the length of nums1 and n is the length of nums2. We find indices m1 and m2 such that m1 + m2 = k, and they satisfy nums1[m1] < nums2[m2 + 1] and nums2[m2] < nums1[m1 + 1].
---
### 2. **Binary Search on min(nums1, nums2)**
#### General idea: Instead of tracking both arrays, we can only track the array with smaller length, so assume nums1 is the smaller array. Let m1 be the pointer in nums1, then the corresponding pointer in nums2 is (m + n + 1) / 2 - m1. Using these, we get the left and right values of both arrays. To be a valid partition, the left values from each array should be less than or equal to the right values of the other array (nums1 left ≤ nums2 right and nums2 left ≤ nums1 right). If this condition is not satisfied, we adjust the search range in nums1 using binary search (move left or right based on the comparison) and repeat. We also need to handle boundary cases when the partition is at the edges of either array. Once the correct partition is found, we compute the median based on whether the total length is odd or even.
* **Why (m + n + 1) / 2, instead of (m + n) / 2:**
    * When m + n is odd, mid point is ((m + n) / 2) + 1. We can satisfy this with (m + n + 1) / 2
        * Example: if total is 5, then the median will be 3, but 5 / 2 will give 2. By adding 1, it will give 3.
    * When m + n is even, adding 1 will not make any difference.
        * Example, if total is 6, both adding 1 and not adding 1 will give 3.
    * Therefore, (m + n + 1) / 2 will give one unified logic for both odd and even total lengths.
--- 