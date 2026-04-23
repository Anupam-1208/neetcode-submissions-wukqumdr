class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
     // sort based on position
     int[][] pairs = new int[position.length][2];
     for (int i = 0;i < position.length; i++) {
        pairs[i][0] = position[i];
        pairs[i][1] = speed[i];
     }
     Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
     Stack<Double> stack = new Stack<>();
    // if time = (target - curpos) / speed

    // 0 1 _ _ 4 _ _ 7 // 10
    // 10 - 7 / 1 = 3 
    // 10 - 4 / 2 = 3 
    for (int[] p : pairs) {
        double time = (double) (target - p[0]) / p[1];
        if (!stack.isEmpty()) {
            double topTime = stack.peek();
            if (topTime < time) {
                stack.push(time);
            }
        } else {
            stack.push(time);
        }

    }
    return stack.size();

    }
}
