package top.parak.Practice.XC;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-09
 */
public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        String str = "\\";
        while (n-- > 0) {
            String cmd = sc.nextLine();
            if (cmd.equals("pwd")) {
                System.out.println(str);
            } else if (cmd.equals("cd ..")){
                if (str.length() != 1) {
                    int index = str.lastIndexOf("\\");
                    if (index != 0) {
                        str = str.substring(0, index);
                    } else {
                        str = "\\";
                    }
                }
            } else {
                String path = cmd.substring(3);
                if (str.endsWith("\\")) {
                    str = str + path;
                } else {
                    str = str + "\\" + path;
                }
            }
        }
    }
}
