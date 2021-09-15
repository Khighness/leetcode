package top.parak.Practice.PXX;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-05-27
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(process(s));
    }

    private static String process(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            char c = arr[i].charAt(0);
            if (isYuanYin(c)) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i].substring(1)).append(c);
            }
            sb.append("pdd");
            for (int k = 1; k <= i + 1; k++) {
                sb.append('a');
            }
            arr[i] = sb.toString();
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[i]);
            if (i != arr.length - 1) {
                ans.append(' ');
            }
        }
        return ans.toString();
    }

    private static boolean isYuanYin(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' | c == 'i' || c == 'o' || c == 'u';
    }
}
