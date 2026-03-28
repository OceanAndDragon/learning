# 87. Scramble String

#### Link: https://leetcode.com/problems/scramble-string/description/

## Approach
### 1. **Dynamic Programming**
#### General idea: If ***s2*** is a scrambled string of ***s1***, then there should be a point where the first section of ***s1*** and the first section of ***s2*** can form scrambled strings of each other, and the second section of ***s1*** and the second section of ***s2*** can also form scrambled strings of each other. We can make this into a smaller sub-problem to apply the dynamic programming.
* Base case: ***true*** if ***s1*** and ***s2*** are equal, ***false*** if lengths of ***s1*** and ***s2*** are different
* Before we dive into each sub-problem, we can apply pruning to check if ***s1*** and ***s2*** can be scrambled.
    * We can check the frequency of each character and return ***false*** if they don't have same frequencies.
* To store the state of the problem, we can use **HashMap** and form key like ***{s1}#{s2}***.
    * Before solving a sub-problem, check if the key already exists in the map.
    * After computing the result, store it in the map.
* In each sub-problem, we have two choices: **swap** and **non-swap**.
    * From ***i = 1 to n - 1***, we can compare substrings of each ***s1*** and ***s2*** with **swap** or **non-swap**.
        1. Get each substring of ***[0, i)*** and ***[i, n)***, then check. -> **NON-SWAP**
        2. If #1 is not satisfied, we swap two substrings.
            * ***s1: [0, i) and [i, n) vs s2: [n - i, n) and [0, n - i)*** -> **SWAP**
--- 