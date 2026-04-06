import java.util.*;

class Solution {

    private static final int LIMIT = 20000; // max area to check
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int BOUND = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] finish, Set<String> blocked) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start[0] + "," + start[1]);

        while (!queue.isEmpty() && visited.size() <= LIMIT) {
            int[] curr = queue.poll();

            if (curr[0] == finish[0] && curr[1] == finish[1]) {
                return true;
            }

            for (int[] d : DIRS) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];

                String key = nx + "," + ny;

                if (nx >= 0 && ny >= 0 && nx < BOUND && ny < BOUND &&
                    !blocked.contains(key) && !visited.contains(key)) {

                    queue.offer(new int[]{nx, ny});
                    visited.add(key);
                }
            }
        }

        // If we explored enough area, we are not enclosed
        return visited.size() > LIMIT;
    }
}