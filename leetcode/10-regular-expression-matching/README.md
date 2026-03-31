# 10. Regular Expression Matching

#### Link: https://leetcode.com/problems/regular-expression-matching/description/

## Approach
### 1. **Dynamic Programming + Memoization**
#### General idea: We can break this problem into sub-problems which check whether the substring starting at a position in ***s*** matches the substring starting at a position in pattern, ***p***. Before checking if the current pattern is valid, we first consider the wildcard. Basically, if the next char of ***p*** is a wildcard (`*`), there are two choices we can take.
#### First, we can skip the current pattern and wildcard since `*` can represent zero occurrence of the preceding character. Second, if the current pattern is valid, we can move the pointer of ***s*** while keeping the pattern pointer at the same position to represent onr or more occurrences.
#### After handling the wildcard case, if there is no wildcard, we move both pointers to the next position if the current pattern is valid.
* We will have a 2D int arrays to store the state, where ***dp[i][j]*** represents whether ***s[i:]*** matches ***p[j:]***.
    1. 1: valid (***true***)
    2. 0: not visited
    3. -1: not valid (***false***)
* Base case: if we reach the end of pattern, return whether we also reach the end of ***s***.
* In each sub-problem, we check if current pattern is valid.
    1. pointer of ***s*** is within bounds and current char of ***p*** and ***s*** are equal.
    2. current char of ***p*** is `.`.
* We handle the wildcard case first, if there is a wildcard in next pointer of ***p*** is `*`.
    1. skip the current pattern and wildcard (move pointer of ***p*** by 2) -> **ZERO OCCURRENCE**.
    2. if the current pattern is valid, move the pointer of ***s*** only -> **ONE OR MORE OCCURRENCE**.
* If there is no wildcard and pattern is valid, move the both pointers to the next.
--- 
### 2. **Dynamic Programming**
#### General idea:
--- 