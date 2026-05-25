class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        if not position or not speed:
            return None

        stack = []
        pair = [(p,s) for p,s in zip(position,speed)]
        pair.sort(reverse=True)

        for p, s in pair:
            stack.append((target-p) / s)
            if len(stack) > 1 and stack[-1] <= stack[-2]:
                stack.pop()
        return len(stack)