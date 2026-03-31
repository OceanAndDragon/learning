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
### 2. **Dynamic Programming + Iteration**
#### General idea: The overall idea is similar to *Approach #1*. We will use iteration instead of recursion in this approach. Also, instead of going up, we will go down from the end of string to 0. As we go down, we will have to check similar to what we did in *Approach #1*. Before we apply dynamic programming, we will check if current pattern is valid.
#### Then, if the next char of ***s*** is wildcard, we check the state of next of wildcard by checking ***dp[i][j + 2]*** **(ZERO OCCURRENCE)** or we check the state of next of ***s*** by checking ***dp[i + 1][j]*** **(ONE OR MORE OCCURRENCE)**.
#### Finally, if the current pattern is valid, we check the state of next of both pointers by checking ***dp[i + 1][j + 1]***.
* Base case: set ***dp[m][n]*** to true, since empty string and empty pattern will be true.
* Edge case: need to think about the case ***p*** can represent the empty string, when the ***s*** is empty. This is why we are starting the **for loop** of ***s*** from ***m***, not ***m - 1***. For example, when ***s = `""`*** and ***p = `"a*b*"`***, it should be ***true***. If we are starting the loop from ***m - 1***, it will not validate the wildcard and return ***false***.
--- 