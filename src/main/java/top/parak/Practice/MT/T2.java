package top.parak.Practice.MT;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-21
 */
public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            boolean flag = false;
            String[] strs = sc.nextLine().split(" ");
            int a = Integer.parseInt(strs[0]), b = Integer.parseInt(strs[1]);
            for (int i = a; i <= b; i++) {
                if (isOK(i)) {
                    System.out.print(i + " ");
                    if (!flag) flag = true;
                }
            }
            if (flag)
                System.out.println();
            else
                System.out.println("no");
        }
    }

    public static boolean isOK(int var) {
        int sum = 0, tmp = var;
        while (tmp != 0) {
            int curr = tmp % 10;
            sum += curr * curr * curr;
            tmp /= 10;
        }
        return sum == var;
    }
}
