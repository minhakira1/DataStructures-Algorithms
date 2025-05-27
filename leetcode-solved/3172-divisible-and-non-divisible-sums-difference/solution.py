class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        sumAll = (1+n)*n//2
        sumMultiples = sum(num for num in range(m,n+1,m))
        sumNonMultiples = sumAll - sumMultiples
        return sumNonMultiples - sumMultiples
        
