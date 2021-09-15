package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-30
 * @apiNote 134. 加油站
 */
public class T134 {

    /**
     * 滑动窗口
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0, curr = 0, len =  gas.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = gas[i] - cost[i];
        }
        for (;left < len; left++) {
            curr = 0;
            for (int i = 0; i < len; i++) {
                curr += temp[(i + left) % len];
                if (curr < 0) {
                    break;
                }
            }
            if (curr >= 0) {
                return left;
            }
        }
        return -1;
    }

    /**
     * 曲线最低点
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curr = 0, len = gas.length;
        int min = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 0; i < len; i++) {
            curr += gas[i] - cost[i];
            if (curr < min) {
                min = curr;
                minIndex = i;
            }
        }
        return min < 0 ? -1 : (minIndex + 1) % len;
    }
}
