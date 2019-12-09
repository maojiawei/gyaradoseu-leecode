package io.jovi.gyaradoseu.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Title:
 * </p >
 * <p>
 * Description:
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-12-05.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = LRUCache.newInstance(2);
        cache.put(1, 1);
        System.out.println("1========================================");
        System.out.println(cache);
        cache.put(2, 2);
        System.out.println("2========================================");
        System.out.println(cache);
        cache.put(1, 1);
        System.out.println("3========================================");
        System.out.println(cache);
        cache.put(3, 3);
        System.out.println("4========================================");
        System.out.println(cache);

        int a = cache.get(1);
        System.out.println("5========================================");
        System.out.println(a);
        System.out.println(cache);
    }

    private LRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K, V> LRUCache<K, V> newInstance(int size) {
        return new LRUCache<K, V>(size);
    }

}
