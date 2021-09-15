package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 401. 二进制手表
 */
public class T401 {
    List<String> res;
    List<Integer> mins;

    /**
     * <h2>回溯</h2>
     * <pre>
     * 小时灯：[1, 2, 4, 8]
     * 分钟灯：[1, 2, 4, 8, 16, 32]
     * </pre>
     * <pre>
     * +---------------+---------------+---------------+---------------+
     * |     type      |    express    |   effective   |     count     |
     * +---------------+---------------+---------------+---------------+
     * |     hour      | [0, 2^4-1(15)]|    [0, 11]    |     [0, 3]    |
     * +---------------+---------------+---------------+---------------+
     * |    minute     | [0, 2^6-1(63)]|    [0, 59]    |     [0, 5]    |
     * +---------------+---------------+---------------+---------------+
     * </pre>
     * <pre>
     * 设『亮灯数量』= num
     * 若『分钟灯』= x，则『小时灯』= num - x
     * </pre>
     * <pre>
     * ∵ x ∈ [0, 5]
     * ∴ 可用一个[0, 5]的for循环
     * ∵ num - x ∈ [0,3]
     * ∴ 可用一个[0, 3]的for循环
     * </pre>
     * <pre>
     * 设计回溯：
     * 1. 所有的灯只有两种情况：要么亮，要么灭
     * 2. 只有亮灯才能减少num的数量
     * 3. 亮的灯所对应的二进制值需要统计
     * 4. 二进制值的和满足要求才能进入下一层递归
     * 5. 当num减到0时，代表这种情况成立，计入答案
     * </pre>
     *
     */
    public List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        mins = new ArrayList<>();

        for (int i = 0; i < 6 && i <= num; i++) {
            dfs(0, 0, i, true);
            dfs(0, 0, num - i, false);
            mins.clear();
        }

        return res;
    }

    /**
     * @param index 选择位置
     * @param total 总时间
     * @param curr  剩余灯数
     * @param flag  true 分钟, false 小时
     */
    private void dfs(int index, int total, int curr, boolean flag) {
        if (curr == 0) {
            if (flag) {
                mins.add(total);
            } else {
                if (!mins.isEmpty()) {
                    for (int min : mins) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(total).append(':');
                        if (min < 10) sb.append('0');
                        res.add(sb.append(min).toString());
                    }
                }
            }
            return;
        }
        for (int i = index; i <= (flag ? 5 : 3); i++) {
            int temp = (int) Math.pow(2, i);
            if ((flag && total + temp >= 60) || (!flag && total + temp >= 12)) {
                break;
            }
            dfs(index + 1, total + temp, curr - 1, flag);
        }
    }
}
