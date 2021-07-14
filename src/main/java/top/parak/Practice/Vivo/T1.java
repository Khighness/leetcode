package top.parak.Practice.Vivo;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-06-17
 */

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int ans = 0;
        for (String str : arr) {
            if (str.contains("7")) {
                ans++;
                continue;
            }
            if (Integer.parseInt(str) % 7 == 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
