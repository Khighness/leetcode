package top.parak.Practice.MT;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char c1; int c2;
            if (x % c == 0) {
                c1 = (char) ('A' + x / c - 1);
                c2  = c;
            } else {
                c1 = (char) ('A' + x / c);
                c2  = x % c;
            }
            System.out.println(Character.toString(c1) +  c2);
        }
    }
}
