# 49. Group Anagrams

#### Link: https://leetcode.com/problems/group-anagrams/description/

## Approach
### 1. **HashMap with Sorted Key**
#### General idea: Use a HashMap where the key is the sorted version of each word. Since anagrams produce the same sorted string, they naturally map to the same key. For each word, sort its characters to generate the key, then append the word to the corresponding list in the map. Return all values of the map as the final result. Time complexity is O(n * k * log(k)) where n is the number of words and k is the max word length. Space complexity is O(n * k) accounting for both the stored words and the keys.