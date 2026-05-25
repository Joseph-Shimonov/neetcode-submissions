class Twitter:

    def __init__(self):
        self.time = 0
        self.tweetMap = defaultdict(list)
        self.followerMap = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append([self.time, tweetId])
        self.time -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        output = []
        minheap = []

        self.followerMap[userId].add(userId)
        for followee in self.followerMap[userId]:
            if followee in self.tweetMap:
                index = len(self.tweetMap[followee]) - 1
                time, tweetId = self.tweetMap[followee][index]
                minheap.append([time, tweetId, followee, index-1])
        
        heapq.heapify(minheap)
        while minheap and len(output) < 10:
            time, tweetId, followee, index = heapq.heappop(minheap)
            output.append(tweetId)
            if index >= 0:
                time, tweetId = self.tweetMap[followee][index]
                heapq.heappush(minheap, [time, tweetId, followee, index-1])
        
        return output

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followerMap[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followerMap[followerId]:
            self.followerMap[followerId].remove(followeeId)
