package top.parak.Algorithm.LoadBalance;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 负载均衡——加权随机
 */
public class RandomWithWeightLoadBalance {

    /**
     * @param serverAddressAndWeight 可用服务器IP和相应权重
     * @return 服务器IP
     */
    public String doSelect(Map<String, Integer> serverAddressAndWeight) {
        int weightSum = serverAddressAndWeight.values().stream().mapToInt(Integer::intValue).sum();
        Random random = new Random();
        int index = random.nextInt(weightSum);
        for (Map.Entry<String, Integer> entry : serverAddressAndWeight.entrySet()) {
            index -= entry.getValue();
            if (index <= 0) {
                return entry.getKey();
            }
        }
        return null;
    }

}
