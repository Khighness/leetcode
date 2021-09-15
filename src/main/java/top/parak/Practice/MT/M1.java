package top.parak.Practice.MT;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-11
 */
public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = 0, cur = 0, n = str.length();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                cur = Integer.parseInt(str.substring(i, j + 1));
                if (cur % 22 == 0) ans++;
            }
        }
        System.out.println(ans);
    }
}
