import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
class Twitter {
    Map<Integer, ListNode> tList;//记录每个人发的推特
    Map<Integer, List<Integer>> followList;//记录每个人的关注者

    public class ListNode implements Comparable<ListNode> {
        //每条推文都是一个节点，每个人的都是一条链表
        int id;
        int primaryKey;
        ListNode next;

        ListNode() {
        }

        public int compareTo(ListNode node) {
            return node.primaryKey - this.primaryKey;
        }
    }

    int count = 0;//推文自增id

    /** Initialize your data structure here. */
    public Twitter() {
        tList = new HashMap<>();//记录每个人发的推特
        followList = new HashMap();//记录每个人的关注者
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ListNode msg = new ListNode();
        msg.id = tweetId;
        msg.primaryKey = count++;
        if (tList.containsKey(userId)) {
            msg.next = tList.get(userId);
            tList.put(userId, msg);
        } else {
            //新建该用户的推特
            msg.next = null;
            tList.put(userId, msg);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //首先先拿到K组链表
        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        if (followList.get(userId) != null) {
            for (int i = 0; i < followList.get(userId).size(); i++) {
                if (tList.containsKey(followList.get(userId).get(i)))
                    pq.add(tList.get(followList.get(userId).get(i)));
            }
        }
        //然后，把自己发的推特也加上
        if (tList.containsKey(userId))
            pq.add(tList.get(userId));
        //然后排序,最后输出  
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        ListNode pre = new ListNode();
        ListNode result = pre;
        //放到优先级队列中自由发挥即可        
        while (!pq.isEmpty() && count < 10) {
            ListNode temp = pq.poll();
            if (temp.next != null) {
                pq.add(temp.next);
            }
            answer.add(temp.id);
            count += 1;
        }

        //System.out.println(answer);
        return answer;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followList.containsKey(followerId)) {
            followList.put(followerId, new ArrayList<>());
        }
        if(!followList.get(followerId).contains(followeeId)){
            followList.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followList.containsKey(followerId)) {
            List<Integer> a = followList.get(followerId);
            if (followList.get(followerId).contains(followeeId))
                followList.get(followerId).remove((Integer) followeeId);
        }
    }
    /*
    Your runtime beats 93.64 % of java submissions
    Your memory usage beats 73.66 % of java submissions (36.5 MB)
    */
}
    
    
    
    /**
    * Your Twitter object will be instantiated and called as such:
    * Twitter obj = new Twitter();
    * obj.postTweet(userId,tweetId);
    * List<Integer> param_2 = obj.getNewsFeed(userId);
    * obj.follow(followerId,followeeId);
    * obj.unfollow(followerId,followeeId);
    */
// @lc code=end

