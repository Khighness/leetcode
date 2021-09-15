package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1108. IP 地址无效化
 */
public class T1108 {

    public String defangIPaddr(String address) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                list.add(i);
            }
        }
        int index = 0;
        StringBuilder newAddr = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                newAddr.append(address, index, list.get(i)).append("[.]");
                index = list.get(i) + 1;
            } else {
                newAddr.append(address, index, list.get(i)).append("[.]");
                newAddr.append(address.substring(list.get(i) + 1));
            }
        }
        return newAddr.toString();
    }

    // 使用正则表达式
    public String regulaeExpression(String address) {
        return address.replace(".", "[.]");
    }

}
