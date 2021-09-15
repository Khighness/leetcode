package top.parak.Practice.HW;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-18
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), M = sc.nextInt();
        int[] arr = new int[M];
        boolean[] visit = new boolean[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        solution(arr, visit, 0, 0, X);
        System.out.println(ans == 0 ? -1 : ans);
    }

    private static int ans = 0;

    /**
     * 深搜
     *
     * @param arr   数组
     * @param index 当前决策下标
     * @param curr  当前总和
     * @param X     目标总和
     */
    private static void solution(int[] arr, boolean[] visit, int index, int curr, int X) {
        if (curr == X) {
            ans++;
            return;
        }
        if (curr > X || index == arr.length - 1) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (!visit[i]) {
                if (i > 0 && arr[i] == arr[i - 1]) continue;
                curr += arr[i];
                visit[i] = true;
                solution(arr, visit, index + 1, curr, X);
                visit[i] = false;
                curr -= arr[i];
            }
        }
    }
}
