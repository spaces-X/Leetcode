import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

class Solution {
    private int n;
    List<List<String>> answers;
    private int[] hasQueue;                                  // input the index of rows to get the queen's column~
    private String rowChar;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        hasQueue = new int[n];
        answers = new ArrayList<>();
        rowChar = new String("");
        for (int i = 0; i < n; i++) {
            rowChar+='.';
            hasQueue[i] = -n-2;
        }
        FindQueen(0);
        return answers;

    }
    public boolean isValid(int row,int col)
    {
        for (int i = 0; i < n; i++) {
            if(hasQueue[i]==col || Math.abs(row-i)==Math.abs(col-hasQueue[i]))
            {
                return false;
            }
        
        }
        return true;
    }
    public void FindQueen(int row)
    {
        if(row == n)                                        // 得到新解返回
        {
            List<String> oneAnswer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(rowChar);
                sb.setCharAt(hasQueue[i], 'Q');
                oneAnswer.add(sb.toString());
            }
            answers.add(oneAnswer);
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row,i)) {
                hasQueue[row]=i;
                FindQueen(row+1);
                hasQueue[row]=(-n-2);
            }
        }

    }
}