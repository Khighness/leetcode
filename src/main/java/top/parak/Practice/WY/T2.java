package top.parak.Practice.WY;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-21
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.next().split(",");
        int n = Integer.parseInt(in[0]), k = Integer.parseInt(in[1]);
        String sn = process(n);
        System.out.println(sn.charAt(k - 1));
    }

    public char findKthBit (int n, int k) {
        // write code here
        return process(n).charAt(k - 1);
    }

    private static String process(int n) {
        String s1 = "a", s2 = null;
        for (int i = 2; i <= n; i++) {
            s2 = s1 + (char) (i - 1 + 'a') + reverse(s1);
            s1 = s2;
        }
        return s2;
    }

    private static String reverse(String s) {
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(invert(arr[i]));
        }
        return builder.toString();
    }

    private static char invert(char c) {
        return (char) (('a' + 'z' - c) % ('z' + 1));
    }
}
