import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter {
    List<int[]> tweets;
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new ArrayList<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[] { userId, tweetId });
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followed = follows.get(userId);

        for (int i = tweets.size() - 1; i >= 0; i--) {
            int posterId = tweets.get(i)[0];
            if (userId == posterId || (followed != null && followed.contains(posterId))) {
                result.add(tweets.get(i)[1]);
                if (result.size() == 10) {
                    break;
                }
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, v -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            if (follows.get(followerId).contains(followeeId)) {
                follows.get(followerId).remove(followeeId);
            }
        }
    }
}
