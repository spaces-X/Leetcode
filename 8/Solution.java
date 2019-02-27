/**
 * Solution
 */
class Solution {
    public static int myAtoi(String str) {
        int sign = 1,i=0;
        int result = 0;
        str = str.trim();
        if(str.isEmpty())
        {
            return result;
        }
        if(str.charAt(i)=='+')
        {
            i++;
        }
        else if(str.charAt(i)=='-')
        {
            i++;
            sign=-1;
        }
        while(i<str.length() && Character.isDigit(str.charAt(i)))
        {
            int current = str.charAt(i)-'0';
            if (result>(Integer.MAX_VALUE-current)/10)
            {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = result*10+current;
            i++;
        }
        return result*sign;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("   -555221ss"));
    }
}