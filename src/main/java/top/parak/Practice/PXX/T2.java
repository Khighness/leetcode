package top.parak.Practice.PXX;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-05-27
 */
public class T2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[] arr = new char[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.next().charAt(0);
//        }
//        System.out.println(process(arr));
//    }
//    /**
//     * 1, 2, 3, 3+1, 4
//     */
//    private static int process(char[] arr) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : arr) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        int[] count = new int[4];
//        for (Integer i : map.values()) {
//            count[i-1]++;
//        }
//        return count[1] + count[3] + Math.max(count[0], count[1]);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        System.out.println(process(arr));
    }

    private static int process(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int[] count = new int[4];
        for (Integer i : map.values()) {
            count[i-1]++;
        }
        return count[1] + count[3] + Math.max(count[0], count[1]);
    }
}
