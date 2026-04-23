class MinStack {
    private List<Integer> stack;
    private int size;
    private List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
        size = 0;
    }
    
    public void push(int val) {
        if (size == 0) {
            stack.add(val);
            minStack.add(val);
            size++;
            return;
        }
        stack.add(val);
        minStack.add(Math.min(val,minStack.get(size-1)));
        size++;
    }
    
    public void pop() {
        if (size == 0) {
            return;
        }
        size--;
        stack.removeLast();
        minStack.removeLast();
        
    }
    
    public int top() {
        if (size == 0) {
            return -1;
        }
        return stack.get(size-1);
    }
    
    public int getMin() {
        if (size == 0) {
            return -1;
        }
        return minStack.get(size-1);
    }
}
