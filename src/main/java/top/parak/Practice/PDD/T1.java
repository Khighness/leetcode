package top.parak.Practice.PDD;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-05-26
 */

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 45)
            System.out.println(process(n));
        else if (n == 45)
            System.out.println(123456789);
        else
            System.out.println(-1);
    }

    public static int process(int n) {
        Set<Integer> set = new HashSet<>();
        int sum, temp;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            set.clear();
            sum = 0;
            temp = i;
            while (temp > 0) {
                int digit = temp % 10;
                if (set.contains(digit)) {
                    break;
                }
                set.add(digit);
                sum += digit;
                temp /= 10;
            }
            if (sum == n) {
                return i;
            }
        }
        return -1;
    }
}
