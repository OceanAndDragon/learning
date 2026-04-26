# 289. Game of Life

#### Link: https://leetcode.com/problems/game-of-life/description/

## Approach
### 1. **Two-State Encoding In-Place Simulation**
#### General idea: Introduce two additional transient states to encode cell transitions in-place, avoiding the need for an auxiliary board. This allows neighbor lookups to reflect the original state while updates are applied directly.
#### There are 2 phases:
1. **Encode Transitions:** Iterate every cell. For each cell, count live neighbors by treating both `1` (live) and `-1` (was live, now dying) as alive. Apply the following encoding:
   - Live cell (`1`) with fewer than 2 or more than 3 live neighbors → mark as `-1` (Live → Dead)
   - Dead cell (`0`) with exactly 3 live neighbors → mark as `2` (Dead → Live)
   - All other cells remain unchanged.
2. **Finalize State:** Iterate every cell again and resolve transient states:
   - `-1` → `0` (dead)
   - `2` → `1` (live)

#### Key Correctness Insight:
- Updating cells directly with only `0` and `1` causes **state pollution** — later cells read already-updated neighbors instead of the original state, producing incorrect counts.
- Transient states `-1` and `2` preserve the **original state semantics** during neighbor counting while allowing true in-place modification, achieving O(m × n) time and O(1) space.
---
### 2. **Sparse Infinite Board — Live Cell Coordinate Simulation**
#### General idea: When the board is infinite but sparsely populated, represent only live cells as a `Set<Cell>` of coordinates. Process each live cell and its dead neighbors independently to determine the next generation.
#### There are 2 phases:
1. **Process Live Cells and Collect Dead Neighbors:** Iterate all known live cells. For each, count live neighbors via `isLiveCell(x, y)`. Apply survival rule: live cell survives if it has exactly 2 or 3 live neighbors. While counting, collect all unique dead neighbors into a `Set<Cell>` (set uniqueness eliminates the need for a separate visited structure).
2. **Process Dead Neighbors:** Iterate the collected dead neighbor set. For each, count live neighbors via `countLiveNeighbors(r, c)` — a pure, side-effect-free helper. Apply birth rule: dead cell becomes alive if it has exactly 3 live neighbors.

#### Key Correctness Insight:
- Only dead cells **adjacent to at least one live cell** can ever become alive (reproduction rule requires exactly 3 live neighbors). Iterating dead neighbors of live cells is therefore exhaustive — no candidate cell is ever missed.
- Using a `Set<Cell>` (Java record with value equality) for both dead neighbors and output eliminates reference equality bugs that would arise from `Set<int[]>`, and structurally prevents duplicate processing without a separate visited set.
---