import java.util.ArrayList;

class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backTrace("", 0, 0, n);
        return this.ans;
    }
    public void backTrace(String s,int open,int close,int n)
    {
        if(s.length()==n*2)
        {
            this.ans.add(s);
        }
        if(open<n)
        {
            backTrace(s+'(', open+1, close, n);
        }
        if(open > close)
        {
            backTrace(s+')', open, close+1, n);
        }
    }
}


