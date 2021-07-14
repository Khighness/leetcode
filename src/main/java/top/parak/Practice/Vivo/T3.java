package top.parak.Practice.Vivo;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-06-17
 */

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] timeStr = sc.next().split(",");
        String[] depends = sc.next().split(";");
        int n = timeStr.length;
        int[] time = new int[n];
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(timeStr[i]);
        }
     }
}
