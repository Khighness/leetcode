package top.parak.Practice.WZ;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-10
 */
public class T3 {
    /**
     * 前缀序列计算
     * <pre>
     *         pre[1] = arr[1];
     *         pre[2] = arr[1] - arr[2];
     *         pre[3] = arr[1] - arr[2] + arr[3];
     *         pre[4] = arr[1] - arr[2] + arr[3] - arr[4];
     * </pre>
     *
     * 推导原始序列
     * <pre>
     *         arr[1] = pre[1];
     *         arr[2] = pre[1] - pre[2];
     *         arr[3] = pre[3] - pre[2];
     *         arr[4] = pre[3] - pre[4];
     * </pre>
     *
     * i = 1, arr[i] = pre[i];
     * i >= 2,
     * (1) i为奇数，arr[i] = pre[i] - pre[i - 1];
     * (2) i为偶数，arr[i] = pre[i - 1] - pre[i];
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 第0位空出来
        int[] pre = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = sc.nextInt();
        }
        arr[1] = pre[1];
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                arr[i] = pre[i] - pre[i - 1];
            } else {
                arr[i] = pre[i - 1] - pre[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
