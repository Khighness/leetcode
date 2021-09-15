package top.parak.Practice.BD;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-07
 */
public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        System.out.println(N);
        System.out.println(K);
        int[][] in = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                in[i][j] = sc.nextInt();
            }
        }
        int[][] out = solution(in, N, K);
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                System.out.print(out[i][j] + ' ');
            }
            System.out.println();
        }
    }

    private static int[][] solution(int[][] in, int N, int K) {
        int NK = N * K;
        int[][] out = new int[NK][NK];
        for (int i = 0; i < NK; i++) {
            for (int j = 0; j < NK; j++) {
                out[i][j] = in[i % N][j % N];
            }
        }
        return out;
    }
}
