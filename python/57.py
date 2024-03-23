from pyparsing import List


class Solution:
    def insert(
        self, intervals: List[List[int]], newInterval: List[int]
    ) -> List[List[int]]:
        n = len(intervals)
        if not intervals:
            return [newInterval]
        if n == 1 and newInterval[0] > intervals[0][1]:
            return intervals + [newInterval]
        if n == 1 and newInterval[1] < intervals[0][0]:
            return [newInterval] + intervals

        left, right = 0, n - 2
        while left <= right:
            mid = (left + right) // 2
            if intervals[mid][0] < newInterval[0] <= intervals[mid + 1][0]:
                left = mid
                break
            if newInterval[0] <= intervals[mid][0]:
                right = mid - 1
            else:
                left = mid + 1
        if left > right:
            if intervals[-1][1] >= newInterval[0]:
                intervals[-1] = [
                    intervals[-1][0],
                    max(intervals[-1][1], newInterval[1]),
                ]
            return intervals
        if right < left:
            if intervals[0][0] <= newInterval[1]:
                intervals[0] = [min(intervals[0][0], newInterval[0]), intervals[0][1]]
            return intervals
        for i in range(left + 1, n):
            if newInterval[1] < intervals[i][0]:
                break
        else:
            i = n
        return (
            intervals[:left]
            + [
                [
                    min(intervals[left][0], newInterval[0]),
                    max(intervals[i - 1][1], newInterval[1]),
                ]
            ]
            + intervals[i:]
        )
