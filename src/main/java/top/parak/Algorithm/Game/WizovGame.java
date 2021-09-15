package top.parak.Algorithm.Game;

/**
 * @author KHighness
 * @since 2020-10-03
 * @apiNote 威佐夫博弈
 */

public class WizovGame {
    public void play(int a, int b) {
        // 保证 a<=b
        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }
        // 判断 a == (b - a) * 黄金分割系数 (向上取整)
        if ( a == (int) Math.ceil( (b - a) * (1 + Math.sqrt(5.0)) / 2) ) {
            System.out.println("后手获胜");
        } else {
            System.out.println("先手获胜");
        }
    }
}
