package top.parak.Practice.WY;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-21
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");
        int[] N = new int[str.length];
        for (int i = 0; i < N.length; i++) {
            N[i] = Integer.parseInt(str[i]);
        }
        int M = scanner.nextInt();
        System.out.println(solution(N, M));
    }

    private static int solution(int[] N, int M) {
        int l = 0, r = N.length - 1;
        int ans = 0, sum = 0;
        Arrays.sort(N);
        while (l < r) {
            sum = N[l] + N[r];
            if (sum <= M) {
                ans += r - l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
