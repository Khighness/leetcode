package top.parak.Practice.XC;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-09
 */
public class M3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int sum = 0;
        while (m-- > 0) {
            int k = sc.nextInt(), x = sc.nextInt();
            int cur = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == '1') {
                    cur++;
                } else {
                    cur = 0;
                }
                if (cur == k) sum += x;
            }
        }
        System.out.println(sum);
    }
}
