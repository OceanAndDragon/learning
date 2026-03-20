import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class code {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        // the array that will store points in sorted manner
        // 1. sorted by x point
        // 2. start point always comes before end point (make height of start point negative)
        // 3. finally keep point in descending order of height
        List<int[]> points = new ArrayList();
        for (int[] building : buildings) {
            points.add(new int[] {building[0], -building[2]});
            points.add(new int[] {building[1], building[2]});
        }
        Collections.sort(points, (p1, p2) -> (p1[0] == p2[0]) ? Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
        // default height
        maxHeap.put(0, 1);
        // keep track of the previous height
        int prev = maxHeap.firstKey();
        for (int[] point : points) {
            // if negative, it is start point
            if (point[1] < 0) {
                int h = -point[1];
                maxHeap.put(h, maxHeap.getOrDefault(h, 0) + 1);
            } else {
                int count = maxHeap.get(point[1]);
                if (count == 1) {
                    maxHeap.remove(point[1]);
                } else {
                    maxHeap.put(point[1], count - 1);
                }
            }
            int curr = maxHeap.firstKey();
            // if the height changes, put it in the final list
            if (prev != curr) {
                result.add(List.of(point[0], curr));
                prev = curr;
            }
        }
        return result;
    }
    
}
