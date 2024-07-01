class Twitter {

    private int maxTweetsPerFeed;
    public static int timeStamp = 0; 
    private Map<Integer, Set<Integer>> follower;
    private Map<Integer, List<Tweet>> tweets;

    private static class Tweet {
        private int tweetId;
        private int timeStamp;
        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
        public int getTweetId() {
            return tweetId;
        }

        public int getTimeStamp() {
            return timeStamp;
        }

    }

    public Twitter() {
        maxTweetsPerFeed = 10;
        timeStamp = 0;
        tweets = new HashMap<>();
        follower = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            follow(userId, userId);
        }
        tweets.computeIfAbsent(userId, x->new ArrayList<>()).add(0, new Tweet(tweetId, timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->a.timeStamp-b.timeStamp);
        Set<Integer> listOfFollower = follower.get(userId);
        if (listOfFollower != null) {
            for (int userFollower : listOfFollower) {
                List<Tweet> tweetsListByUserId = tweets.get(userFollower);
                if (tweetsListByUserId == null) {
                    continue;
                }
                for (Tweet t : tweetsListByUserId) {
                    if (pq.size() < maxTweetsPerFeed) {
                        pq.offer(t);
                    } else {
                        if (t.timeStamp <= pq.peek().timeStamp) {
                            break;
                        } else {
                            pq.offer(t);
                            pq.poll();
                        }
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getTweetId());
        }
        System.out.println(tweets);
        System.out.println(follower);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follower.computeIfAbsent(followerId, x->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !follower.containsKey(followerId)) {
            return;
        }
        follower.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */