package top.parak.Practice.Shopee;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-07-19
 */
public class T1 {
    public int[] GetEndPoint(String order) {
        // write code here
        int x = 0, y = 0;
        char[] arr = order.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            char dir = arr[i];
            if (Character.isDigit(dir))
                continue;

            if (i == 0 || !Character.isDigit(arr[i-1]))
                l = 1;
            else
                l = arr[i-1] - '0';

            switch (dir) {
                case 'W': y += l;
                    break;
                case 'A': x -= l;
                    break;
                case 'S': y -= l;
                    break;
                case 'D': x += l;
                    break;
                default:break;
            }
        }
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T1().GetEndPoint("W2DWWWWW")));
    }
}
