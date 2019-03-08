/**
 * Solution1
 */
class Solution1 {
    public static boolean isMatch(String s, String p) {
        boolean [][] isMatched = new boolean[s.length()+1][p.length()+1];  // isMatched[i][j] = true 表示从s的i位到末尾 和 p的j位到末尾 匹配成功
        isMatched[s.length()][p.length()]= true;
        for (int i = s.length(); i>=0; i--) {
            for(int j = p.length()-1;j>=0;j--)
            {
                boolean firstedMatched = i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
                if (j+1<p.length() && p.charAt(j+1)=='*'){
                    isMatched[i][j] = firstedMatched && isMatched[i+1][j] || isMatched[i][j+2];
                }
                else{
                    isMatched[i][j] = firstedMatched && isMatched[i+1][j+1];
                }



            }

            
        }
        return isMatched[0][0];
    }
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "ca*b"));
    }
    
}