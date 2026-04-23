class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
     // sort based on position
     int[][] pairs = new int[position.length][2];
     for (int i = 0;i < position.length; i++) {
        pairs[i][0] = position[i];
        pairs[i][1] = speed[i];
     }
     Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
    // if time = (target - curpos) / speed

    // 0 1 _ _ 4 _ _ 7 // 10
    // 10 - 7 / 1 = 3 
    // 10 - 4 / 2 = 3 
    double prevTime = 0;
    int res = 0;
    for (int[] p : pairs) {
        double time = (double) (target - p[0]) / p[1];
        if (time > prevTime) {
            res++;
            prevTime = time;
        }

    }
    return res;

    }
}
