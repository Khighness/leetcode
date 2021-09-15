package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1281. 整数的各位积和之差
 */
public class T1281 {

    public int subtractProductAndSum(int n) {
        int sum = 0, mul = 1;
        while (n != 0) {
            sum += n % 10;
            mul *= n % 10;
            n = n / 10;
        }
        return mul - sum;
    }

}
