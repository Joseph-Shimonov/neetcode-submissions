class Solution:
    def trap(self, height: List[int]) -> int:
        run_max_left = [0] * len(height)
        run_max_right = [0] * len(height)
        min_height = [0] * len(height)

        # get the max left
        run_max_left[0] = 0
        for i in range(1, len(run_max_left)):
            run_max_left[i] = max(height[i-1], run_max_left[i-1])

        # get the max right
        run_max_right[len(height)-1] = 0
        for i in range(len(run_max_right)-2, -1, -1):
            run_max_right[i] = max(height[i+1], run_max_right[i+1])

        # get the minimum
        for i in range(len(height)):
            min_height[i] = min(run_max_left[i], run_max_right[i])

        total = 0
        for i in range(len(min_height)):
            diff = min_height[i] - height[i]
            if diff > 0:
                total += diff
        return total