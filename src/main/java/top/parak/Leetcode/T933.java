package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 933. 最近的请求次数
 */
public class T933 {

    // 链表超时
    class RecentCounter1 {
        List<Integer> list;

        public RecentCounter1() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            list.add(t);
            int ans = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= t - 3000 && list.get(i) <= t) {
                    ans++;
                }
            }
            return ans;
        }
    }

    // 队列欧克
    class RecentCounter2 {
        Queue<Integer> queue;

        public RecentCounter2() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            // 将所有小于t-3000的移出队列
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

}
