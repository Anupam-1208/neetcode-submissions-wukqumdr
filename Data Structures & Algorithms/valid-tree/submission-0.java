class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            adjList.add(new ArrayList());
        }

        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // level 
        // parent / visit
        // queue

        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> level = new HashMap<>();
        q.addLast(0);
        level.put(0,0);

        int lev = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0;i<size;i++) {
                int cur = q.removeFirst();
                List<Integer> children = adjList.get(cur);
                for (int child: children) {
                    if (level.containsKey(child)) {
                        if (level.get(child) >= level.get(cur)) {
                            return false;
                        }
                        continue;
                    }
                    level.put(child, lev);
                    q.addLast(child);
                }
            }
            lev++;
        }
        return level.size() == n;

    }
}
