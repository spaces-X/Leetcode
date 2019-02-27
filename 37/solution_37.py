class Solution:
    board = None
    def solveSudoku(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.board = board
        self.backTrace(0,0)
    def backTrace(self,i: int,j: int) -> bool:
        if i == 8 and j == 9:                     # 当搜索到第9行 第10列的时候 说明 第9行第9列已经填写成功 全部完成 返回即可
            return True
 
        if j == 9:                                # 在行末尾 进行换行操作
            i += 1
            j = 0
        if self.board[i][j]==".":                  # 如果当前为空则进行枚举尝试
            for number in ["1","2","3","4","5","6","7","8","9"]:
                if self.checkValid(i,j,number):
                    self.board[i][j] = number
                    flag = self.backTrace(i,j+1)   # 递归搜索下一个  并用flag 标记是否回溯
                    if flag:                       # flag 为True  说明后面的都成功了 不需要回溯 直接返回True 即可
                        return True
                    # flag 为 false 回溯到当前
                    self.board[i][j] = "."
        else:
            return self.backTrace(i,j+1)          # 当前没有空   继续 

        #  如果枚举了所有从 "1" 到 "9" 发现都不行 则 return false 进行回溯
        return False




    def checkValid(self,row: int,line:int,number:str) -> bool:
        for i in range(9):
            if self.board[row][i] == number or self.board[i][line] ==number:
                return False
        temprow = row//3
        templine = line//3
        for i in range(3):
            for j in range(3):
                if self.board[temprow * 3 + i][templine * 3 + j] == number:
                    return False
        return True

if __name__ == "__main__":
    input = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
    sa = Solution()
    sa.solveSudoku(input)
    
