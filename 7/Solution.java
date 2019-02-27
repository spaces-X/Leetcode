/**
 * Solution
 */
public class Solution {

    public static int reverse(int x)
    {
        long result=0L;
        int current;
        while(x!=0)
        {
            current = x % 10;
            result = result*10+current;
            if(result>2147483647 || result<-2147483648)
            {
                return 0;
            }
            x = x/10;
        }
        return (int)result;
    }
    public static void main(String[] args) {
        int a = 1563847412;
        System.out.println(reverse(a));
    }
}