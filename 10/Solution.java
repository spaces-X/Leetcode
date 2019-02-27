/**
 * Solution
 * 递归法实现正则匹配
 */
class Solution {
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty()){
            for (int i = 1; i < p.length(); i+=2) {
                if(p.charAt(i)!='*')
                {
                    return false;
                }
                
            }
            return p.length()%2 == 0;
        }
        boolean first_matched = (p.length()>0) && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.' ); // 第一位是否匹配？
        // 递归条件
        if (p.length()>1 && p.charAt(1)=='*'){
            return (first_matched && isMatch(s.substring(1), p)) || (isMatch(s, p.substring(2)));  // p中第二位带星： 如果第一位匹配  则s中去掉第一位继续匹配p；如果第一位不匹配 则s不变  p去点前2位（也就是*为0次）
        }
        else{                                                                                      // p中第二位不带星： 如果第一位匹配 则 继续看 s[1:] 和p[1:]，如果第一位不匹配 直接返回false
            return first_matched && isMatch(s.substring(1), p.substring(1));
        }

            
        }
        public static void main(String[] args) {
            System.out.println(isMatch("mississippi", "mis*is*ip*i"));
        }
        
    }