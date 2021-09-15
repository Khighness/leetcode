package top.parak.Practice.Ali;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-05-31
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- != 0) {
            int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
            boolean[][] b = new boolean[n][n];
            int ans = 0;
            // 开灯
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt(), y = sc.nextInt();
                for (int k = 0; k < n; k++) {
                    b[x][k] = true;
                    b[k][y] = true;
                }
                for (int u = 0; u < n; u++) {
                    for (int v = 0; v < n; v++) {
                        if (Math.abs(u - x) == Math.abs(v - y)) {
                            b[u][v] = true;
                        }
                    }
                }
            }
            // 访问
            for (int i = 0; i < q; i++) {
                int x = sc.nextInt(), y = sc.nextInt();
                if (b[x][y]) ans++;
                for (int u = x - 1; u <= x + 1; u++) {
                    for (int v = y - 1; v <= y + 1; y++) {
                        if (u >= 0 && v >= 0 && u < n && v < n) {
                            b[u][v] = false;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
