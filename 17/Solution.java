import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0)
            return result;
        if(digits.length()==1)
            return get(digits.charAt(0));
        List<String> temp1 = letterCombinations(digits.substring(0,digits.length()-1));
        List<String> temp2 = get(digits.charAt(digits.length()-1));
        for (int i = 0; i < temp1.size(); i++) {
            for (int j = 0; j < temp2.size(); j++) {
                result.add(temp1.get(i)+temp2.get(j));
            }
        }
        return result;
    
    }
    public static List<String> get(char number)
    {
        if (number=='2'){
            return Arrays.asList("a","b","c");
        }
        if (number=='3'){
            return Arrays.asList("d","e","f");
        }
        if (number=='4'){
            return Arrays.asList("g","h","i");
        }
        if (number=='5'){
            return Arrays.asList("j","k","l");
        }
        if (number=='6'){
            return Arrays.asList("m","n","o");
        }
        if (number=='7'){
            return Arrays.asList("p","q","r","s");
        }
        if (number=='8'){
            return Arrays.asList("t","u","v");
        }
        if (number=='9'){
            return Arrays.asList("w","x","y","z");
        }
        return null;
        
    }
    public static void main(String[] args) {
        String input  = "23";
        System.out.println(letterCombinations(input));

    }
}