import java.util.Stack;
class Solution {
    public static boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else{
                if(s.charAt(i)=='}'&&stack.peek()=='{' ||s.charAt(i)==']'&&stack.peek()=='['|| s.charAt(i)==')'&&stack.peek()=='(')
                {
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }

        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "(){()}";
        System.out.println(isValid(s));
    }
}