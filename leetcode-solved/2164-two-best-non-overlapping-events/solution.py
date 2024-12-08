class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        # Step 1: Sort events by their end time
        events.sort(key=lambda x: x[1])  # Sort by `end` time
        n = len(events)
        
        # Step 2: Initialize variables
        max_value = 0  # Maximum value seen so far
        result = 0     # Result to store the maximum sum
        dp = []        # List to store (end_time, max_value) pairs
        
        # Step 3: Process each event
        for start, end, value in events:
            # Binary search for the best non-overlapping event
            idx = bisect.bisect_left(dp, (start,))  # Find the first event whose `end_time` >= `start`
            if idx > 0:
                max_non_overlap_value = dp[idx-1][1]
            else:
                max_non_overlap_value = 0
            
            # Update the result with the sum of current event and the best non-overlapping event
            result = max(result, value + max_non_overlap_value)
            
            # Update max_value and dp array
            max_value = max(max_value, value)
            dp.append((end, max_value))
        
        return result
