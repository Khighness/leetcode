package top.parak.Practice.WY;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-21
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int ans = 1, cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                cur++;
            }
            ans += cur;
        }
        System.out.println(ans);
    }

    private static int solution(int[] arr) {
        int ans = 0, cur = 1;
        int min = arr[0], minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex =i;
            }
        }
        for (int i = minIndex - 1; i >= 0; i--) {
            if (arr[i] == arr[i + 1]) {

            } else if (arr[i] > arr[i + 1]) {
                cur += 1;
            } else {

            }
        }
        for (int i = minIndex + 1; i < arr.length; i++) {

        }
        return 0;
    }
}
