class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {
            '}': '{',
            ']': '[',
            ')': '('
        }

        for bracket in s:
            if bracket in '([{':
                stack.append(bracket)
                continue
            if not stack or stack.pop() != pairs[bracket]:
                return False

        return not stack
            