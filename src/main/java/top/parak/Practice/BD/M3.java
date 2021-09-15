package top.parak.Practice.BD;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-09-07
 */
public class M3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String s = sc.next();
        List<String> set = sub(s);
        int ans = 0;
        for (String str : set) {
            if (getCount(str) == k) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static List<String> sub(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        String path = "";
        process(str, 0, ans, path);
        return ans;
    }

    private static void process(char[] str, int index, List<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        process(str, index + 1, set, path);
        process(str, index + 1, set, path + str[index]);
    }

    private static int getCount(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            set.add(c);
        }
        return set.size();
    }
}
