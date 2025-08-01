class Solution:
    def transformArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        idx = 0
        for num in nums:
            if num%2 == 0:
                nums[idx] = 0
                idx+=1
        # remain space in array will be only 1
        for i in range(idx, n):
            nums[i] = 1
        return nums
