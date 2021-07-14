package top.parak.Algorithm.Face;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021/3/15
 * @apiNote 打印一个字符串的全排列
 */

public class PrintAllPermutations {

    public List<String> permutation(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        process2(str, 0, ans);
        return ans;
    }

    /**
     * 暴力递归，不包含重复子序列只需把list换成set即可
     */
    private void process(char[] str, int i, List<String> list) {
        if (i == str.length) {
            list.add(String.valueOf(str));
        }
        // i: 目前正在选择的字符位置
        // j：可与选择位置交换的索引
        for (int j = i; j < str.length; j++) { // i后面的字符都有机会与i交换
            swap(str, i, j);
            process(str, i + 1, list);
            swap(str, i, j);                   // 恢复现场
        }
    }

    private void swap(char[] str, int var1, int var2) {
        char temp = str[var1];
        str[var1] = str[var2];
        str[var2] = temp;
    }

    /**
     * 分支限界，排除重复字符串
     */
    private void process2(char[] str, int i,List<String> list) {
        if (i == str.length) {
            list.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process2(str, i + 1, list);
                swap(str, i, j);
            }
        }
    }

}
