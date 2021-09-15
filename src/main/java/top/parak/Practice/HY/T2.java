package top.parak.Practice.HY;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-26
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        int ans = hexStrToInt(hex);
        System.out.println(ans);
    }

    public static int hexStrToInt(String hex) {
        char[] arr = hex.toCharArray();
        int sum = 0, cur = 0;
        for (char c : arr) {
            if (Character.isDigit(c)) {
                cur = c - '0';
            } else {
                cur = hexCharToInt(c);
            }
            sum = 16 * sum + cur;
        }
        return sum;
    }

    public static int hexCharToInt(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'a': return 10;
            case 'b': return 11;
            case 'c': return 12;
            case 'd': return 13;
            case 'e': return 14;
            case 'f': return 15;
        }
        throw new IllegalArgumentException();
    }
}
