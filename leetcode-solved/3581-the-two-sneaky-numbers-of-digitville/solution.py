class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        countArr = [0] * n
        for num in nums:
            countArr[num]+=1
        result = []
        for i,num in enumerate(countArr):
            if(num == 2):
                result.append(i)
        return result
