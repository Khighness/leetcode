package top.parak.Practice.AQY;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-01
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] str = input.substring(1, input.length() - 1).split(",");
        int n = str.length;
        // 操作
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int[] res = process(arr, n);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < n - 1; i++)
            sb.append(res[i]).append(',');
        sb.append(res[n - 1]).append(']');
        System.out.println(sb.toString());
    }

    private static int[] process(int[] arr, int n) {
        // 状态
        int[] sta = new int[n];
        // 结果
        int[] res = new int[n];
        // 贪心
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) { // 下雨
                res[i] = -1;
                sta[arr[i]] -= 1;
                if (sta[i] == -2) {
                    return new int[0];
                }
            } else {
                for (int j = i + 1; j < n; j++) {
                    if (res[i] == 0 && arr[j] > 0 && sta[arr[j]] < 0) { // 抽水
                        res[i] = arr[j];
                        sta[arr[j]] = 0;
                    }
                }
            }
        }
        return res;
    }
}
