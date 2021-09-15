package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 51. N 皇后
 */
public class T51 {
    /** 皇后数量，即棋盘大小 */
    int n;
    /** 下标代表第几个皇后，值代表皇后下标 */
    int[] arr;
    /** 每一种结果对应的棋盘结果 */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        arr = new int[n];
        process(0);
        return res;
    }

    /**
     * 放置皇后，检验合格
     *
     * @param index 决策第index个皇后
     */
    public void process(int index) {
        if (index == n) {
            place();
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[index] = i;
            if (check(index)) { // 当前放置OK则放置下一个
                process(index + 1);
            } // 不OK则换下一个位置
        }
    }

    /**
     * @param index 检查第index个皇后
     */
    public boolean check(int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == arr[index] // 同列
            || Math.abs(index - i) == Math.abs(arr[index] - arr[i])) // 对角线
                return false;
        }
        return true;
    }

    /**
     * 绘制字符串
     */
    public void place() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int place = arr[i];
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < place; k++) sb.append('.');
            sb.append('Q');
            for (int k = place + 1; k < n; k++) sb.append('.');
            list.add(sb.toString());
        }
        res.add(list);
    }

}
