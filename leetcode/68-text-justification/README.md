# 68. Text Justification

#### Link: https://leetcode.com/problems/text-justification/description/

## Approach
### 1. **Greedy Line Building + Space Distribution**
#### General idea: The key idea is to greedily pack as many words as possible into each line, then distribute the remaining spaces evenly across the gaps between words. We maintain two variables, `numWords` and `currLength`, to track the current group of words being built.
#### At each index `i`, we check whether adding the next word exceeds `maxWidth`. The condition is `currLength + words[i].length() + numWords > maxWidth`, where `numWords` accounts for the minimum one space between each word (since spaces go between words, not after every word).
#### There are 2 phases:
1. **Line Grouping:** Greedily accumulate words into the current line. At each index `i`, compute `newLength = currLength + words[i].length() + numWords`. If `newLength > maxWidth`, flush the current group and start a new one by resetting `numWords` and `currLength` to 0.

2. **Space Distribution:** Once a group is flushed, distribute remaining spaces across `numWords - 1` gaps:
   - `evenSpaces = (maxWidth - currLength) / (numWords - 1)`
   - `extraSpaces = (maxWidth - currLength) % (numWords - 1)`
   - The first `extraSpaces` gaps get `evenSpaces + 1` spaces, remaining gaps get `evenSpaces` spaces.

#### There are 2 special cases we need to handle:
1. **Single word on a line**, where `numWords == 1` after flush: skip space distribution entirely and left-justify by appending the word then padding the remaining `maxWidth - wordLength` trailing spaces to the right.
2. **Last line**, where `i == n - 1`: regardless of how many words are on the last line, always left-justify by joining words with a single space and padding remaining spaces to the right. This also covers the case where the entire input fits on one line.
---