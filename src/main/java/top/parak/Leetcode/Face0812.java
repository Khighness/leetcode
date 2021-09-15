package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 面试题 08.12. 八皇后
 */
public class Face0812 {
    int n;
    int[] arr;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.arr = new int[n];
        this.res = new ArrayList<>();
        process(0);
        return res;
    }

    private void process(int index) {
        if (index == n) {
            place();
        } else {
            for (int i = 0; i < n; i++) {
                arr[index] = i;
                if (check(index)) {
                    process(index + 1);
                }
            }
        }
    }

    private boolean check(int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == arr[index] || Math.abs(index - i) == Math.abs(arr[index] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void place() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < arr[i]; k++) sb.append('.');
            sb.append('Q');
            for (int k = arr[i] + 1; k < n; k++) sb.append('.');
            list.add(sb.toString());
        }
        res.add(list);
    }

}
