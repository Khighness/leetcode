package top.parak.Algorithm.Game;

/**
 * @author KHighness
 * @since 2020-10-03
 * @apiNote 斐波那契博弈
 */
public class FibonacciGame {
    public int fibnacci(int n) {
        // 递归计算，慢
//        if (n == 1 || n == 2)
//            return 1;
//        else
//            return fibnacci(n - 1) + fibnacci(n - 2);
        // 公式计算，快
        return (int) Math.floor( ( Math.pow((1 + Math.sqrt(5)) / 2, n)  - Math.pow((1 - Math.sqrt(5)) / 2, n) ) / Math.sqrt(5) );
    }

    public void play(int n) {
        for (int i = 1; fibnacci(i) <= n; i++) {
            if (fibnacci(i+1) == n) {
                System.out.println("后手获胜");
                return;
            }
        }
        System.out.println("先手获胜");
    }
}
