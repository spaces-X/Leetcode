class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        int minlength = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder();
        // result.append("");
        for (String str : strs) {
            if(str.length()<minlength)
                minlength = str.length();
        }
        String temp = strs[0];
        for (int i = 0; i < minlength; i++) {
            boolean flag = true;
            for(int j = 1;j<strs.length;j++)
            {
                if(strs[j].charAt(i)!=temp.charAt(i))
                {
                    flag=false;
                }
            }
            if(flag)
            {
                result.append(temp.charAt(i));
            }
            else{
                break;
            }
            
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String [] inputs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(inputs));
    }
}