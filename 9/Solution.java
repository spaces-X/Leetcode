class Solution {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if(s.charAt(i)!=s.charAt(len-1-i))
            {
                return false;
            }
            
        }
        return true;
        
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}