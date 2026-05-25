class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []        

    def push(self, val: int) -> None:
        self.stack.append(val)

        if not self.min_stack or self.min_stack[-1] >= val:
            self.min_stack.append(val)

    def pop(self) -> None:
        if not self.stack:
            raise EmptyStackError("Stack is empty")
        
        popped_val = self.stack.pop()
        if popped_val == self.min_stack[-1]:
            self.min_stack.pop()
        

    def top(self) -> int:
        if not self.stack:
            raise EmptyStackError("Stack is empty")
        return self.stack[-1]

    def getMin(self) -> int:
        if not self.min_stack:
            raise EmptyStackError("Stack is empty")
        return self.min_stack[-1]