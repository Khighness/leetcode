package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 1138. 字母板上的路径
 */

public class T1138 {
    public String alphabetBoardPath(String target) {
        // 当前坐标
        int x = 0, y = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : target.toCharArray()) {
            // 寻找字符所在坐标
            int newX = (c - 'a') / 5, newY = (c - 'a') % 5;
            if (newX < x) { // 目标在上边
                for (int i = 0; i < x - newX; i++)
                    builder.append('U');
            }
            if (newY < y) { // 目标在左边
                for (int i = 0; i < y - newY; i++)
                    builder.append('L');
            }
            if (newX > x) { // 目标在下边
                for (int i = 0; i < newX - x; i++)
                    builder.append('D');
            }
            if (newY > y) { // 目标在右边
                for (int i = 0; i < newY - y; i++)
                    builder.append('R');
            }
            // 执行连接
            builder.append('!');
            // 更新坐标
            x = newX; y = newY;
        }
        return builder.toString();
    }
}
