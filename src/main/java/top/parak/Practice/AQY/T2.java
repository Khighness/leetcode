package top.parak.Practice.AQY;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-08-01
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split(",");
        int n = str.length;
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        String[] end = str[n - 1].split(":");
        arr[n - 1] = Integer.parseInt(end[0]);
        int k = Integer.parseInt(end[1]);
        System.out.println(process(arr, n, k));
    }

    private static String process(int[] arr, int n, int k) {
        double ans = 0, cur = 0;
        int pre = 0, sum = 0;
        // 第一个窗口
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // 后续窗口
        for (int i = k ; i < n; i++) {
            pre = sum;
            sum += arr[i] - arr[i - k];
            cur = (sum - pre) * 1.0 / pre;
            ans = Math.max(cur, ans);
        }
        return String.format("%.2f", ans * 100) + '%';
    }
}
