package top.parak.Practice.JD;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-24
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] count = new int[m];
        for (int i = 0; i < n; i++) {
            count[sc.nextInt() - 1]++;
        }
        int maxIndex = 0, max = count[0];
        for (int i = 1; i < m; i++) {
            if (max < count[i]) {
                max = count[i];
                maxIndex = i;
            }
        }
        System.out.println((maxIndex + 1) + " " + count[maxIndex]);
    }
}
