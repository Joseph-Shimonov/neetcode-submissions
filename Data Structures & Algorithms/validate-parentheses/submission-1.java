class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        // create a stack
        Stack<Character> stack = new Stack<>();

        // convert the string to a char array
        char[] arr = s.toCharArray();

        // iterate over the arr
        for (char c: arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            else if ((c == ')' || c == '}' || c == ']') && stack.isEmpty()) {
                return false;
            }

            else if ((c == ')' && stack.peek() != '(') ||
                (c == '}' && stack.peek() != '{') ||
                (c == ']' && stack.peek() != '[')) {
                return false;
            }

            else {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
