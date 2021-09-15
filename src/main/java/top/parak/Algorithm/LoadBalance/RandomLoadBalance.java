package top.parak.Algorithm.LoadBalance;

import java.util.List;
import java.util.Random;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 负载均衡——随机
 */
public class RandomLoadBalance {

    /**
     * @param serviceAddress 可用服务器IP地址列表
     * @return 服务器IP
     */
    public String doSelect(List<String> serviceAddress) {
        Random random = new Random();
        int index = random.nextInt(serviceAddress.size());
        return serviceAddress.get(index);
    }

}
