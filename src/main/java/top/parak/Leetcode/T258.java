package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-10
 * @apiNote 258. 各位相加
 */
public class T258 {

    public int addDigits(int num) {
        return solution(num);
    }

    /**
     * 递归解
     */
    public int solution(int num) {
        if (num < 10) return num;
        int newNum = 0;
        while (num > 0) {
            newNum += num % 10;
            num /= 10;
        }
        return solution(newNum);
    }

    /**
     * O(1)
     */
    public int solution2(int num) {
        return (num - 1) % 9 + 1;
    }

}
