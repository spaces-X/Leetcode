/**
 * Solution
 */
public class Solution {
    public static String  convert(String s, int numRows) {
        StringBuilder result = new StringBuilder("");
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            boolean odd = true;
            int skip;
            int j =i;
            int index = j;
            while(index<len)
            {
                result.append(s.charAt(index));
                skip = (odd||i==0)?(numRows-1-i)*2:i*2;   // 除了第一行和最后一行其他的行跳过的字符数 和 奇偶性相关
                if (i==numRows-1) {
                    skip = (numRows-1)*2;
                }
                skip = skip<1?1:skip;
                odd = !odd;
                index +=skip;
            }
            
        }
        return result.toString();

        
    }
    public static void main(String[] args) {
        String a = "012345";
        System.out.println(convert(a, 2));
    }
}