package top.parak.Practice.Zoom;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-04-01
 */
public class T1 {

    // accddeffss
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int end = array.length - 1;
        while (index <= end) {
            int offset = index;
            while (offset + 1 <= end) {
                if (array[index] != array[offset + 1])
                    break;
                else offset += 1;
            }
            sb.append(array[index]).append('_')
                    .append(offset - index + 1)
                    .append(offset == end ? "" : "_");
            index = offset + 1;
        }
        System.out.println(sb.toString());
    }
}
