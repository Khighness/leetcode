package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 12:07
 * @apiNote 1108. IP 地址无效化
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
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
        String newAddr = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                newAddr += address.substring(index, list.get(i)) + "[.]";
                index = list.get(i) + 1;
            } else {
                newAddr += address.substring(index, list.get(i)) + "[.]";
                newAddr += address.substring(list.get(i) + 1);
            }
        }
        return newAddr;
    }

    // 使用正则表达式
    public String regulaeExpression(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(new T1108().regulaeExpression("192.168.117.111"));
    }

}
