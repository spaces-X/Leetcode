/**
 * Solution
 */
public class Solution {

    public static boolean isPalindrome(String s)
    {
        if(s.equals(""))
        {
            return false;
        }
        int i=0;
        while(i<(s.length()/2))
        {
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
            {
                return false;
            }
            i++;
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            for(int j=i+1;j<=s.length();j++)
            {
                if(j-i>maxlength && isPalindrome(s.substring(i, j)))
                {
                    maxlength=j-i;
                    longestPalindrome = s.substring(i,j);
                }
            }
            
        }
        return longestPalindrome;
    }
    public static void main(String[] args) {
        String s = new String("abasddsa");
        System.out.println(s.length());
        System.out.println(longestPalindrome(s));
    }
    
}