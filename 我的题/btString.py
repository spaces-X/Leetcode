
def btString(ls):
    # isVisted = [False]*len()
    backTrace(0,len(ls))
    print(ans)



def backTrace(i,max):
    if (max//2)-1 ==i:
        ans.append(ls.copy())
        return
    print(i)
    backTrace(i+1,max)
    swap(ls,i)
    backTrace(i+1,max)
    

def swap(ls,i):
    i = i*2
    t = ls[i] 
    ls[i] = ls[i+1]
    ls[i+1] = t

if __name__ == "__main__":
    ans = []
    ls = [1,2,3,4,5,6]
    btString(ls)
