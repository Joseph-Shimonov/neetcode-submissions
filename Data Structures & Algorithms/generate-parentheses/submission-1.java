class Solution {
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        // output
        List<String> output = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), output);
        return output;
    }

    public void dfs(int n, int open, int closed, StringBuilder s, List<String> output) {
        if (open+closed == n*2) {
            output.add(s.toString());
            return;
        }

        if (open < n) {
            dfs(n, open+1, closed, s.append('('), output);
            s.deleteCharAt(s.length()-1);
        }
        if (closed < open) {
            dfs(n, open, closed+1, s.append(')'), output);
            s.deleteCharAt(s.length()-1);
        }
    }
}
