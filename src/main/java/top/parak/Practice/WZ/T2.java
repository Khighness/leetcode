package top.parak.Practice.WZ;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-10
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),
                m = sc.nextInt(),
                x = sc.nextInt(),
                y = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        char[] ops = sc.next().toCharArray();
        int curx = 0, cury = 0, sum = 0;
        for (int i = 0; i < ops.length; i++) {
            char o = ops[i];
            int delta = 0;
            // 碰到墙壁或者障碍物
            switch (o) {
                case 'h': { // 向左
                    if (cury == 0 || arr[curx][cury - 1] == -1) {
                        delta = y;
                    } else {
                        delta = Math.max(arr[curx][cury], arr[curx][cury - 1]);
                        cury -= 1;
                    }
                    break;
                }
                case 'j': { // 向下
                    if (curx == n - 1 || arr[curx + 1][cury] == -1) {
                        delta = y;
                    } else {
                        delta = Math.max(arr[curx][cury], arr[curx + 1][cury]);
                        curx += 1;
                    }
                    break;
                }
                case 'k': { // 向上
                    if (curx == 0 || arr[curx - 1][cury] == -1) {
                        delta = y;
                    } else {
                        delta = Math.max(arr[curx][cury], arr[curx - 1][cury]);
                        curx -= 1;
                    }
                    break;
                }
                case 'l': { // 向右
                    if (cury == m - 1 || arr[curx][cury + 1] == -1) {
                        delta = y;
                    } else {
                        delta = Math.max(arr[curx][cury], arr[curx][cury + 1]);
                        cury += 1;
                    }
                    break;
                }
                default:
                    break;
            }
            sum += delta;
            // 如果改变方向
            if (i > 0 && o != ops[i - 1]) {
                sum += x;
            }
        }
        System.out.println(sum);
    }
}
