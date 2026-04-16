# 151. Reverse Words in a String

#### Link: https://leetcode.com/problems/reverse-words-in-a-string/description/

## Approach
### 1. **Split and Reverse**
#### General idea: Trim the input string to remove leading and trailing spaces, split by `\\s+` regex to handle multiple spaces between words, then iterate in reverse order to build the result using a `StringBuilder`.
#### There are 3 phases:
1. **Trim and Split:** Trim `s` to remove leading/trailing spaces, then split using `\\s+` regex to produce an array of words without empty strings caused by multiple spaces.
2. **Reverse Iteration:** Iterate the word array from last index to first, appending each word to a `StringBuilder` followed by a space.
3. **Final Trim:** Call `.trim()` on the final `StringBuilder` output to remove the trailing space added after the last word.
---
### 2. **In-Place CharArray Reversal**
#### General idea: Convert the trimmed string to a `char[]` and perform three phases — reverse the entire array, reverse each individual word, then compact multiple spaces into single spaces using a two-pointer technique. The `trim()` upfront guarantees no trailing space in the final output.
#### A reusable `reverse(char[], start, end)` helper is used throughout:
- Swaps characters from both ends moving inward until `start >= end`
- Used for both full reversal and per-word reversal
#### There are 3 phases:
1. **Full Reverse:** Reverse the entire `char[]` so that words appear in reverse order but each word itself is also reversed.
2. **Per-Word Reverse:** Scan through the array using a read pointer. Upon detecting a non-space character, find the word boundary using an inner `while` loop, then reverse that word's range `[i, end-1]` to restore correct character order.
3. **Space Compaction (Two-Pointer):** Use a `read` pointer and a `write` pointer. Copy non-space characters directly. Upon hitting a space, write exactly one space and advance `read` past all consecutive spaces. Since `s` was trimmed upfront, the array is guaranteed to end on a word, so `write` will never include a trailing space. Return `new String(singleChars, 0, write)`.
---