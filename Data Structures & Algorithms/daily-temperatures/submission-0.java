class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                output[prev] = i-prev;
            }
            stack.push(i);
        }
        return output;
    }
}
