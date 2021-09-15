package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 剑指 Offer 65. 不用加减乘除做加法
 */
public class Offer65 {

    /**
     * 对于二进制a和b
     * s(和) = n(非进位) + c(进位)
     * 循环求每一位的非进位和进位
     * 非进位 n = a ^ b
     * 进位  c  = a & b << 1
     */
    public int add(int a, int b) {
        while (b != 0) { // 进位为0时跳出循环
            int c = (a & b) << 1; // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
