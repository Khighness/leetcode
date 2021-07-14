package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 15:31
 * @apiNote 933. 最近的请求次数
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem:
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求.
 * 请你实现 RecentCounter 类：
 *      RecentCounter() 初始化计数器，请求数为 0 。
 *      int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 */
public class T933 {

    // 链表超时。。。
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

    // 队列欧克。。。
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
