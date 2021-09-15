package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 831. 隐藏个人信息
 */
public class T831 {

    public String maskPII(String s) {
        char[] arr = s.toCharArray();
        int index = s.indexOf('@');
        StringBuilder ans = new StringBuilder();
        if (index > 0) { // 邮箱
            if (Character.isLetter(arr[0]))
                arr[0] = Character.toLowerCase(arr[0]);
            if (Character.isLetter(arr[index-1]))
                arr[index-1] = Character.toLowerCase(arr[index-1]);
            ans.append(arr[0]).append("*****").append(arr[index - 1]).append('@');
            for (int i = index + 1; i < arr.length; i++) {
                char c = arr[i];
                if (Character.isLetter(c))
                    c = Character.toLowerCase(c);
                ans.append(c);
            }
            return ans.toString();
        } else { // 电话
            for (char c : arr) {
                if (Character.isDigit(c)) {
                    ans.append(c);
                }
            }
            String ansStr = ans.toString();
            int len = ansStr.length();
            if (len == 10) return "***-***-" + ansStr.substring(6);
            ans = new StringBuilder("+");
            for (int i = 10; i < len; i++) ans.append('*');
            return ans.append("-***-***-").append(ansStr.substring(len - 4)).toString();
        }
    }

}
