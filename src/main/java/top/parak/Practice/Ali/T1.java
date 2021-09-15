package top.parak.Practice.Ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-05-31
 */
public class T1 {

    private static char[] arr;
    private static char[] cho = {'0', '1', '2', '3'};
    private static int[] res = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = sc.next().replace("R", "0").replace("B", "1").
                replace("Y", "2").replace("G", "3").
                replace("!", "4").toCharArray();
        dfs(0);
        System.out.println(Arrays.toString(arr));
        for (int i : res) System.out.printf("%d ", i);
    }

    private static void dfs(int index) {
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] != '4') continue;
            for (int k = 0; k < 4; k++) {
                arr[index] = cho[k];
                if (check(index)) {
                    res[cho[k]-'0']++;
                    dfs(index + 1);
                    res[cho[k]-'0']--;
                }
            }
        }
    }

    private static boolean check(int index) {
        int start = Math.max(0, index - 3);
        int end = Math.min(arr.length - 1, index + 3);
        for (int i = start; i <= index; i++) {
            for (int j = i + 1; j <= index; j++) {
                if (arr[i] == arr[j] && arr[i] != '4') {
                    return false;
                }
            }
        }
        for (int i = index; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arr[i] == arr[j] && arr[i] != '4') {
                    return false;
                }
            }
        }
        return true;
    }
}
