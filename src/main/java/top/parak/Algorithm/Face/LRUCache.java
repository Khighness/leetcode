package top.parak.Algorithm.Face;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 线程安全的LRU缓存
 */
public class LRUCache<K, V> {

    /**
     * 最大容量
     */
    private final int maxCapacity;
    /**
     * 存储键值对
     */
    private ConcurrentHashMap<K, V> cache;
    /**
     * 存储有效键
     */
    private ConcurrentLinkedQueue<K> keys;
    /**
     * 读写锁
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    private ScheduledExecutorService scheduledExecutorService;

    public LRUCache(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("Illegal max capacity: " + maxCapacity);
        }
        this.maxCapacity = maxCapacity;
        cache = new ConcurrentHashMap<>(maxCapacity);
        keys = new ConcurrentLinkedQueue<>();
        scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    }

    /**
     * 放入缓存
     *
     * @param key          键
     * @param value        值
     * @param expireTime   过期时间
     * @param unit         时间单位
     * @return 如果缓存中已存在相同键，返回该键的值，否则返回插入的值
     */
    public V put(K key, V value, long expireTime, TimeUnit unit) {
        if (expireTime < 0) {
            throw new IllegalArgumentException("Illegal expire time: " + expireTime);
        }
        // 加写锁
        writeLock.lock();
        try {
            V val = cache.get(key);
            // key已经存在
            if (val != null) {
                moveLast(key);
                cache.put(key, value);
                return val;
            } else {
                // 缓存已满
                if (cache.size() == maxCapacity) {
                    removeHead();
                }
                keys.add(key);
                cache.put(key, value);
                if (expireTime > 0) {
                    removeAfterExpireTime(key, expireTime, unit);
                }
                return value;
            }
        } finally {
            // 释放写锁
            writeLock.unlock();
        }
    }

    /**
     * 获取键对应的值
     *
     * @param key 键
     * @return 值
     */
    public V get(K key) {
        // 加读锁
        readLock.lock();
        try {
            V val = get(key);
            if (val != null) {
                moveLast(key);
                return val;
            }
            return null;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 获取缓存中的键值对数量
     *
     * @return 键值对的数量
     */
    public int size() {
        return cache.size();
    }

    /**
     * 将key移动到队列尾部
     */
    private void moveLast(K key) {
        keys.remove(key);
        keys.add(key);
    }

    /**
     * 移除队列头部key和缓存中的键值对
     */
    private void removeHead() {
        K key = keys.poll();
        if (key != null) {
            cache.remove(key);
        }
    }

    /**
     * 清除过期key
     */
    private void removeAfterExpireTime(K key, long expireTime, TimeUnit unit) {
        scheduledExecutorService.schedule(() -> {
            cache.remove(key);
            keys.remove(key);
        }, expireTime, unit);
    }
}
