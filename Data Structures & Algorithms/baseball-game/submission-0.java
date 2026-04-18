class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        // 1 2  
        // score
        for (String op: operations) {
            if (op.equals("+")) {
                // add last 2 value
                int f = s.pop();
                int se = s.pop();
                s.push(se);
                s.push(f);
                s.push(f+se);

            } else if (op.equals("C")) {
                // remove top value
                int v = s.pop();
            } else if (op.equals("D")) {
                // double last/top value
                s.push(2*s.peek());
            } else {
                s.push(Integer.parseInt(op));
            }


        }
        int res = 0;
        while (!s.isEmpty()) {
            int t = s.pop();
            res += t;
        }

        return res;

    }
}