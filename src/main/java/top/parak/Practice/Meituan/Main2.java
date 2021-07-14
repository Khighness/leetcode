package top.parak.Practice.Meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-04-25
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int q = sc.nextInt();
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < q; i++) {
            stack.push(new int[] {
               sc.nextInt(), sc.nextInt(), sc.nextInt() % 26
            });
        }
        while (!stack.isEmpty()) {
            int[] arr = stack.pop();
            int l = arr[0];
            int r = arr[1];
            int k = arr[2];
            for (int i = l - 1; i <= r - 1; i++) {
                str[i] = (char) ( (str[i] - k >= 'a') ? (str[i] - k) : (str[i] - k + 26) );
            }
        }
        System.out.println(new String(str));
    }
}
