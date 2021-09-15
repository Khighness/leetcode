package top.parak.Algorithm.Face;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-03-15
 * @apiNote 打印一个字符串的全部子序列，不包含重复子序列。
 */
public class PrintAllSubsquences {

    public Set<String> sub(String s) {
        Set<String> ans = new HashSet<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        String path = "";
        process(str, 0, ans, path);
        return ans;
    }

    private void process(char[] str, int index, Set<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        String no = path;
        process(str, index + 1, set, no);
        String yes = path + str[index];
        process(str, index + 1, set, yes);
    }

    public static void main(String[] args) {
        System.out.println(new PrintAllSubsquences().sub("abcd"));
    }

}
