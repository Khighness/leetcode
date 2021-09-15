package top.parak.Practice.PDD;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-08
 */
public class M1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[3];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < 3; k++) {
                arr[k] = sc.nextInt();
            }
            int ans = getCount(arr[0], arr[1], arr[2]);
            System.out.println(ans);
        }
    }

    private static int getCount(int x0, int y0, int r) {
        // x轴交点  (y - y0)^2 = r^2 - x0^2
        // y轴交点  (x - x0)^2 = r^2 - y0^2
        x0 = x0 * x0;
        y0 = y0 * y0;
        r = r * r;
        int count = 0;
        if (x0 == r)
            count += 1;
        else if (x0 < r)
            count += 2;
        if (y0 == r)
            count += 1;
        else if (y0 < r)
            count += 2;
        // 交点重合
        if (x0 + y0 == r)
            count -= 1;
        return count;
    }
}
