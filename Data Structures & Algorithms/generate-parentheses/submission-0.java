class Solution {
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        // output
        List<String> output = new ArrayList<>();

        // stack
        Stack<Character> stack = new Stack<>();
        dfs(n, 0, 0, stack, output);
        return output;
    }

    public void dfs(int n, int open, int closed, Stack<Character> stack, List<String> output) {
        if (open == closed && open == n) {
            for (char c: stack) {
                sb.append(c);
            }
            output.add(sb.toString());
            sb.setLength(0);
            return;
        }

        if (open < n) {
            stack.push('(');
            dfs(n, open+1, closed, stack, output);
            stack.pop();
        }
        if (closed < open) {
            stack.push(')');
            dfs(n, open, closed+1, stack, output);
            stack.pop();
        }
    }
}
