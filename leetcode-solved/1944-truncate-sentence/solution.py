class Solution:
    def truncateSentence(self, s: str, k: int) -> str:
        res = ""
        for i, c in enumerate(s):
            iLast = i == len(s)-1
            if(c == ' ' or iLast):
                k-=1
            if(k == 0):
                if(iLast):
                    res = s[:i+1:]
                else:
                    res = s[:i:]
                break
        return res
