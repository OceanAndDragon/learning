import heapq
from typing import List


def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
    points = []
    for sp, ep, h in buildings:
        # start point
        points.append((sp, -h, ep))
        # end point
        points.append((ep, 0, 0))
    # sort by x point, then height
    points = sorted(points, key=lambda p: (p[0], p[1]))
    # default point
    max_heap = [(0, float('inf'))]
    result = []
    # keep trak of the previous height
    prev = max_heap[0][0]
    for sp, h, ep in points:
        # if the end point is passed, we don't need.
        # pop from heap
        while max_heap[0][1] <= sp:
            heapq.heappop(max_heap)
        # if start point, push height and the end point
        if h != 0:
            heapq.heappush(max_heap, (h, ep))
        # if we see any update on max height
        # add it to final list
        if prev != max_heap[0][0]:
            result.append([sp, -max_heap[0][0]])
            prev = max_heap[0][0]
    return result