package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 14:09
 * @apiNote 1342. 将数字变成 0 的操作次数
 */

/**
 * Problem:
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
public class T1342 {
    public int numberOfSteps (int num) {
        int ans = 0;
        while (num != 0) {
            ans++;
//            num = (num % 2 == 0) ? num >> 1 : num - 1;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 8888, y = 8888;
        long t1 = System.nanoTime();
        x = x >> 1;
        long t2 = System.nanoTime();
        long t3 = System.nanoTime();
        y = y / 2;
        long t4 = System.nanoTime();
        System.out.println("> 位运算耗时：" + (t2 -t1) + "ns");
        System.out.println("> 除运算耗时：" + (t4 -t3) + "ns");
    }
}
