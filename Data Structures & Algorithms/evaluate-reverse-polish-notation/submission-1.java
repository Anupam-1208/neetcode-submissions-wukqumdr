class Solution {
    public int evalRPN(String[] tokens) {
        // push numbers
        // evalute when + - * /

        // evaluate means taking first 2 elements and using the operator
        
        Deque<Integer> s = new ArrayDeque<>();
        // s.push(int val)
        // int v = s.pop()
        for (String c: tokens) {
            if (c.equals("+")) {
                int f = s.pop();
                int se = s.pop();
                s.push(f+se);
            } else if (c.equals("-")) {
                int f = s.pop();
                int se = s.pop();
                s.push(se-f);
            } else if (c.equals("*")) {
                int f = s.pop();
                int se = s.pop();
                s.push(f*se);
            } else if (c.equals("/")) {
                int f = s.pop();
                int se = s.pop();
                s.push(se/f);
            } else {
                s.push(Integer.parseInt(c));
            }

        }
        if (!s.isEmpty()) return s.pop();
        return -1;
    }
}
