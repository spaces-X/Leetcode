import java.util.HashMap;

/**
 * Solution
 */
class Solution {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 0;
        int current = 0;
        int sum = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            current = map.get(s.charAt(i));
            sum = current < prev? sum-current:sum+current;
            prev = current;
        }
        return sum;        
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    
}