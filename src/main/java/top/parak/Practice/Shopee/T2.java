package top.parak.Practice.Shopee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-07-19
 */
public class T2 {
    int getValue(int rowIndex, int columnIndex) {
        // write code here
        List<List<Integer>> yh = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    list.add(1);
                } else {
                    list.add(yh.get(i - 2).get(j - 2) + yh.get(i - 2).get(j - 1));
                }
            }
            yh.add(list);
        }
        return yh.get(rowIndex - 1).get(columnIndex - 1);
    }

    public static void main(String[] args) {
        System.out.println(new T2().getValue(4, 3));
    }
}
