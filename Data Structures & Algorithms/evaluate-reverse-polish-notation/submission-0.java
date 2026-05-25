class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length % 2 == 0) {
            return -1;
        }

        // create a stack
        Stack<Integer> stack = new Stack<>();

        // iterate over the tokens
        for (String val: tokens) {
            if (val.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (val.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (val.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (val.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(val));
            }
        }

        return stack.peek();
    }
}
