class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        bracket_map = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        for c in s:
            if c in "([{":
                stack.append(c)
            elif c in bracket_map:
                if not stack or stack.pop() != bracket_map[c]:
                    return False
            else:
                return False
        return not stack
            