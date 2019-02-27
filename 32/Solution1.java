/**
 * Solution1
 */
public class Solution1 {

    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        int dp[] = new int[s.length()];  // 全都初始化为0
        // dp[i] 对应值 的意义是 s中 从0到i: 以第i索引结尾所包含的成对括号的括号数， 注意这个成对儿的括号一定包含 第i位索引 
        // example   String s = "()())()"   则 dp[0] = 0; dp[1]=2; dp[2] = 0 : "()("  包含第三位的话不成对儿 ; dp[3]=4 :"()()" dp[5]=0:"()())"; dp[6]=0:"()())("; dp7=2: "()())()";
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i-1)=='(') {                              // 对应"()"
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }
                else if(i-dp[i-1]>0 && s.charAt(i-1-dp[i-1])=='('){    // 对应"))"
                    dp[i] = dp[i-1] + ( (i-1-dp[i-1]-1)>=0 ? dp[i-1-dp[i-1]-1]: 0 ) + 2;
                    
                }    
            }
            maxlen = Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("())))(())()"));
    }
}