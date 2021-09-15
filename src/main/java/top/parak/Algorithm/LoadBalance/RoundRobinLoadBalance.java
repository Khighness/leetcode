package top.parak.Algorithm.LoadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 负载均衡——轮询
 */
public class RoundRobinLoadBalance {
    /**
     * 当前轮询索引
     */
    private static final AtomicInteger pos = new AtomicInteger(0);
    /**
     * 可用服务器IP列表
     */
    private static final List<String> serviceAddress = new ArrayList<>();

    // 初始化服务器列表
    static {
        // ...
    }

    public String doSelect() {
        if (pos.get() == serviceAddress.size() - 1) {
            pos.set(0);
        }
        return serviceAddress.get(pos.getAndIncrement());
    }
}
