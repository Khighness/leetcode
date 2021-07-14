package top.parak.Practice.PXX;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-05-27
 */

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(process(arr, K));
    }

    private static int process(int[] arr, int K) {
        int ans = 0;
        List<Integer> list = new LinkedList<>();
        // 前K - 1 个元素
        for (int i = 0; i < K - 1; i++) {
            list.add(arr[i]);
        }
        for (int i = K - 1; i < arr.length; i++) {
            list.add(arr[i]);
            List<Integer> sortList = new ArrayList<>(list);
            sortList.sort(Comparator.comparingInt(num -> num));
            ans += sortList.get((K - 1) >> 1);
            list.remove(0);
        }
        return ans;
    }
}
