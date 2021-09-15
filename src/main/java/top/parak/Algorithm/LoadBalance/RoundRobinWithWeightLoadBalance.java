package top.parak.Algorithm.LoadBalance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 负载均衡——加权轮询
 */
public class RoundRobinWithWeightLoadBalance {
    /**
     * 当前轮询索引
     */
    private static final AtomicInteger pos = new AtomicInteger(0);
    /**
     * 服务器IP列表和权值
     */
    private static Map<String, Integer> serverAddressAndWeight = new HashMap<>();

    /**
     * 轮询列表
     */
    private static List<String> serverAddress;

    // 添加服务器和权值，放入轮询列表
    static {
        // ...
        for (Map.Entry<String, Integer> entry : serverAddressAndWeight.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                serverAddress.add(entry.getKey());
            }
        }
    }

    public String doSelect() {
        if (pos.get() == serverAddress.size() - 1) {
            pos.set(0);
        }
        return serverAddress.get(pos.getAndIncrement());
    }
}
