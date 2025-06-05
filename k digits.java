class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            // Remove digits from the stack while the current digit is smaller
            // and we still need to remove more digits (k > 0)
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }

        // If k > 0, remove remaining digits from the end
        while (k-- > 0) {
            stack.pollLast();
        }

        // Build the final number string and remove leading zeros
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
