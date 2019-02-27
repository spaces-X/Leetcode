/**
 * Solution
 * 动态规划解决
 */
public class Solution {

    public static String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int maxlen = 0;
        boolean flag[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            flag[i][i] = true;
            maxlen = maxlen>1?maxlen:1;
            if (i<len-1 && s.charAt(i)==s.charAt(i+1)) {
                flag[i][i+1] = true;
                start = i;
                maxlen = 2;
            }
        }
        for (int strlen = 3; strlen <= len; strlen++) {
            for (int i = 0; i <=len-strlen; i++) {
                int j = i+strlen-1;
                if (flag[i+1][j-1] && s.charAt(i)==s.charAt(j))
                {
                    flag[i][j] = true;
                    maxlen = strlen;   // strlen 是递增的所以 一定会比上一个大
                    start = i;
                }
            }
            
        }
        if (maxlen>0) {
            return s.substring(start,start+maxlen);
        }
        return "";
    }
    public static void main(String[] args) {
        String s = "asdwadsasd";
        String sub = longestPalindrome(s);
        System.out.println(sub);
    }
}