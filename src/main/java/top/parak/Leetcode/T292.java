package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-03
 * @apiNote 292. Nim 游戏
 */
public class T292 {

    /**
     * Solution:
     * 巴什博奕，n%(m+1)==0时，后手总是会赢的。
     * 面对4的整数倍的人永远无法翻身，先手拿N根后手就会拿4-N根，保证每回合共减4根，先手永远对面4倍数，直到4。
     * 相反，如果最开始不是4倍数，先手可以拿掉刚好剩下4倍数根，让后手永远对面4倍数。
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
