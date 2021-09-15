package top.parak.Practice.MT;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-11
 */
public class M2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][] subway = new int[m][2];
        int[][] swap = new int[q][2];
        int[] ans = new int[n + 1];
        for (int i = 0; i < m; i++) {
             subway[i][0] = sc.nextInt();
             subway[i][1] = sc.nextInt();
             ans[subway[i][0]]++;
             ans[subway[i][1]]++;
        }
        for (int i = 0; i < q; i++) {
            swap[i][0] = sc.nextInt();
            swap[i][1] = sc.nextInt();
            swap(ans, swap[i][0], swap[i][1]);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
