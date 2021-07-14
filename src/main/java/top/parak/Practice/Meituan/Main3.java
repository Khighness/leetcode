package top.parak.Practice.Meituan;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-25
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }

            // 无需旋转
            boolean zero = true;
            // 最小索引，最大索引
            int min = n - 1, max = 0;
            for (int j = 0; j < n; j++) {
                if (array[j] != j + 1) {
                    zero = false;
                    min = Math.min(j, min);
                    max = Math.max(j, max);
                }
            }
            if (zero) {
                System.out.println(0);
                continue;
            }

            int res = process(array, min, max);
            if (res == -1) {
                System.out.println(-1);
            } else {
                System.out.println((min + 1) + " " + (max + 1) + " " + res);
            }
        }
    }

    public static int process(int[] array, int l, int r) {
        for (int count = 1; count <= r - l; count++) {
            int temp = array[l];
            for (int i = l; i < r; i++) {
                array[i] = array[i + 1];
            }
            array[r] = temp;
            if (already(array, l, r)) {
                return count;
            }
        }
        return -1;
    }

    public static boolean already(int[] array, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (array[i] != i + 1) {
                return false;
            }
        }
        return true;
    }
}
