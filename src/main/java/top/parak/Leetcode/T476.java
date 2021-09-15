package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-02
 * @apiNote 476. 数字的补数
 */
public class T476 {
    public int findComplement(int num) {
        String n1 = Integer.toBinaryString(num);
        StringBuilder n2 = new StringBuilder();
        int len = n1.length();
        for (int i = 0; i < len; i++) {
            n2.append('1');
        }
        int n = Integer.parseInt(n2.toString(), 2);
        return n ^ num;
    }
}
