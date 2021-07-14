package top.parak.Algorithm.Game;

/**
 * @author: KHighness
 * @date: 2020/10/3 15:57
 * @apiNote: 尼姆博弈
 */

public class NimGame {
    public void play(int[] a) {
        int res = 0;
        for (int i : a) {
            res ^= i;
        }
        if (res == 0) {
            System.out.println("后手获胜");
        } else {
            System.out.println("先手获胜");
        }
    }
}
