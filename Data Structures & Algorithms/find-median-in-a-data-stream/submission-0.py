class MedianFinder:

    def __init__(self):
        self.data = []

    def addNum(self, num: int) -> None:
        self.data.append(num)

    def findMedian(self) -> float:
        self.data.sort()
        n = len(self.data)

        if len(self.data) % 2 == 1:
            return self.data[n // 2]
        return (self.data[n // 2] + self.data[n // 2 - 1]) / 2
        