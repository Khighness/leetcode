package top.parak.Practice.WZ;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-10
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int k = sc.nextInt();
            System.out.println(isOK(k) ? "YES" : "NO");
        }
    }

    private static boolean isOK(int k) {
        if (k <= 2) return false;
        long cur;
        for (int x = 1; x <= 10000; x++) {
            cur = x * x * x;
            if (cur >= k) return false;
            for (int y = 1; y <= 1000; y++) {
                cur = x * x * x + y * y * y * y;
                if (cur >= k) break;
                for (int z = 1; z <= 1000; z++) {
                    cur = x * x * x + y * y * y * y + z * z * z * z * z;
                    if (cur == k)
                        return true;
                    else if (cur > k)
                        break;
                }
            }
        }
        return false;
    }
}
