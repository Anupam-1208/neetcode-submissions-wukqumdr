class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String t : tokens) {
            // Use .equals() for content comparison in Java
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                // The first pop is the second operand (right side)
                int val2 = stack.pop();
                // The second pop is the first operand (left side)
                int val1 = stack.pop();
                
                switch (t) {
                    case "+": stack.push(val1 + val2); break;
                    case "-": stack.push(val1 - val2); break;
                    case "*": stack.push(val1 * val2); break;
                    case "/": stack.push(val1 / val2); break;
                }
            } else {
                // Push integers directly onto the stack
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
