package top.parak.Algorithm.Game;

/**
 * @author KHighness
 * @since 2020-10-03
 * @apiNote 巴什博弈
 */
public class BashGame {
    public void play(int n, int m) {
        if ((n % (m + 1)) == 0) {
            System.out.println("后手获胜");
        } else {
            System.out.println("先手获胜");
        }
    }
}
