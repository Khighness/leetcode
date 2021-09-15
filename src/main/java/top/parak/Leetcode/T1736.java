package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-24
 * @apiNote 1736. 替换隐藏数字得到的最晚时间
 */
public class T1736 {

    public String maximumTime(String time) {
        StringBuilder builder = new StringBuilder();
        char[] arr = time.toCharArray();
        if (arr[0] == '?')
            arr[0] = arr[1] == '?' || arr[1] < '4' ? '2' : '1';
        if (arr[1] == '?')
            arr[1] = arr[0] == '2' ? '3' : '9';
        return builder
                .append(arr[0]).append(arr[1]).append(arr[2])
                .append(arr[3] == '?' ? '5' : arr[3])
                .append(arr[4] == '?' ? '9' : arr[4])
                .toString();
    }

}
