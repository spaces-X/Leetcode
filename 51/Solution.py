class Solution:
    # n=-1                # n皇后
    # answers = []     # 存放所有answer
    # hasQueue=[]      # 存放第i行对应皇后的列索引位，  (i,hasQueue[i]) 是皇后的坐标位置
    def solveNQueens(self, n):
        self.answers=[]
        self.n=n
        self.hasQueue = [-n-1]*n
        self.findQueen(0)
        return self.answers
    

    def isValid(self,row,col):                       # 判断（row,col）位置是否可以放皇后
        for i in range(self.n):
            if col==self.hasQueue[i] or abs(row-i) == abs(col-self.hasQueue[i]):
                return False
        return True
    
    def findQueen(self,row):
        if row==self.n:
            oneAnswer = []
            for Q in self.hasQueue:
                line = ['.']*self.n
                line[Q] = 'Q'
                line = "".join(line)
                oneAnswer.append(line)
            self.answers.append(oneAnswer)
            return 
        for i in range(self.n):
            if self.isValid(row,i):
                self.hasQueue[row] = i
                self.findQueen(row+1)
                self.hasQueue[row] = -self.n-1    # 回溯
        
