package top.parak.Practice.MT;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-21
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while (sc.hasNextLine()) {
            double sum = 0;
            String[] strs = sc.nextLine().split(" ");
            double a = Double.parseDouble(strs[0]), n = Integer.parseInt(strs[1]);
            for (int i = 0; i < n; i++) {
                sum += a;
                a = Math.sqrt(a);
            }
            System.out.println(df.format(sum));
        }
    }
}
