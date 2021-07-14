package top.parak.Practice.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-29
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int res = solution(n, array);
        System.out.println(res);
    }

    public static int solution(int n, int[] array) {
        if (n == 1)
            return array[0];
        else if (n == 2)
            return Math.min(array[0], array[1]);
        else {
            Arrays.sort(array);
            if (array[0] != array[1])
                return array[0];
            for (int i  = 1; i < n - 1; i++) {
                if (array[i] != array[i - 1] && array[i] != array[i + 1]) {
                    return array[i];
                }
            }
            if (array[n - 2] != array[n - 1]) {
                return array[n - 1];
            }
        }
        return -1;
    }
}
