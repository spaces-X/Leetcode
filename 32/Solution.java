import java.util.Stack;

class Solution {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxlen = 0;
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') {
                stack.add(i);
            }
            else{
                stack.pop();
                if(stack.empty())
                {
                    stack.add(i);
                }
                else{
                    maxlen = Math.max(maxlen, i-stack.peek());
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(())())("));
    }
}