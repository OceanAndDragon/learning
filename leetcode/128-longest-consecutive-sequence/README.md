# 128. Longest Consecutive Sequence

#### Link: https://leetcode.com/problems/longest-consecutive-sequence/description/

## Approach
### 1. **HashSet with Sequence Start Detection**
#### General idea: Load all values into a HashSet, then iterate the set and only begin counting from numbers that are the start of a consecutive sequence (i.e., `num - 1` is not in the set). This guarantees O(n) time by ensuring each number is visited at most once across all sequence walks.

#### There are 2 phases:
1. **Build the Set:** Iterate `nums` and add every element into a `HashSet<Integer>`. Duplicates are automatically deduplicated by the set, eliminating the need for any explicit duplicate handling later.
2. **Find Longest Sequence:** Iterate the set directly. For each number, check if `num - 1` is absent in the set — if so, this number is the start of a consecutive sequence. Walk forward by incrementing `curr` until `curr` is no longer in the set, counting the length. Update `maxSequence` with `Math.max(maxSequence, currSequence)`.

#### Key Design Decisions:
- **Iterate the set, not the original array:** Iterating the `HashSet` instead of `nums` avoids revisiting duplicate values and keeps the logic clean without needing explicit removal during iteration.
- **Sequence start detection:** Skipping numbers where `num - 1` exists ensures the inner while loop only runs from true sequence starts, giving an amortized O(n) total across all walks.
- **O(1) lookup:** All `contains()` calls on `HashSet` are O(1), which is the core enabler of the overall O(n) time complexity.

#### Complexity:
- **Time:** O(n) — each number is added to the set once and visited at most once during sequence walks.
- **Space:** O(n) — the HashSet stores up to n unique elements in the worst case.

#### Edge Cases Handled:
- **Empty array:** `maxSequence` is initialized to `0`, returned directly with no iteration.
- **All duplicates:** Set deduplication reduces to a single unique value; handled naturally.
- **No consecutive sequence:** Every number is its own sequence of length 1; correctly captured in the walk.
---