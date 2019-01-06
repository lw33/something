package lw.learn.lc.design;

import org.junit.Test;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-01-05 23:55:26
 **/
public class P355_DesignTwitter {

    class Twitter {

        class Tweet implements Comparable<Tweet> {
            private long time;
            private int tweeId;

            public Tweet(long time, int tweeId) {
                this.time = time;
                this.tweeId = tweeId;
            }

            @Override
            public int compareTo(Tweet o) {
                return Long.compare(this.time, o.time);
            }
        }

        private Map<Integer, ArrayList<Tweet>> tweetMap;
        private Map<Integer, Set<Integer>> follow;
        private long timestamp;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            tweetMap = new HashMap<>();
            follow = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            ArrayList<Tweet> tweetList = tweetMap.getOrDefault(userId, new ArrayList<>());

            //long epochMilli = Instant.now().toEpochMilli() + Instant.now().getNano();
            tweetList.add(new Tweet(timestamp++, tweetId));
            tweetMap.putIfAbsent(userId, tweetList);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            ArrayList<Tweet> userNews = tweetMap.get(userId);
            Set<Integer> followees = follow.get(userId);
            if (userNews == null && followees == null) {
                return new ArrayList<>();
            }
            int top = 10;
            List<Integer> res = new ArrayList<>(10);
            PriorityQueue<Tweet> pq = new PriorityQueue<>();
            if (userNews != null) {
                for (int i = userNews.size() - 1; i >= 0; i--) {
                    Tweet tweet = userNews.get(i);
                    if (pq.size() == top) {
                        if (pq.peek().compareTo(tweet) < 0) {
                            pq.poll();
                            pq.add(tweet);
                        } else {
                            break;
                        }
                    } else {
                        pq.add(tweet);
                    }
                }
            }
            if (followees != null) {
                for (Integer followee : followees) {
                    ArrayList<Tweet> tweets = tweetMap.get(followee);
                    if (tweets != null) {
                        for (int i = tweets.size() - 1; i >= 0; i--) {
                            Tweet tweet = tweets.get(i);
                            if (pq.size() == top) {
                                if (pq.peek().compareTo(tweet) < 0) {
                                    pq.poll();
                                    pq.add(tweet);
                                } else {
                                    break;
                                }
                            } else {
                                pq.add(tweet);
                            }
                        }
                    }
                }
            }


            while (!pq.isEmpty()) {
                res.add(0, pq.poll().tweeId);
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }
            Set<Integer> set = follow.getOrDefault(followerId, new HashSet<>());
            set.add(followeeId);
            follow.putIfAbsent(followerId, set);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }
            if (follow.containsKey(followerId)) {
                if (follow.get(followerId).contains(followeeId)) {
                    follow.get(followerId).remove(followeeId);
                }
            }
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
    @Test
    public void test() {
        //["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
        //[[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1]]
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        System.out.println(twitter.getNewsFeed(1));
    }
}
