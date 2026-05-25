class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {
            '}': '{',
            ']': '[',
            ')': '('
        }

        for bracket in s:
            if not stack and bracket in pairs:
                return False
            elif bracket in pairs and stack.pop() != pairs[bracket]:
                return False
            
            if bracket not in pairs:
                stack.append(bracket)

        return not stack
            